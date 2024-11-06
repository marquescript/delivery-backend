package com.delivery.api.infra.external_services;

import com.delivery.api.domain.providers.AddressProvider;
import com.delivery.api.infra.http.dto.TravelInfo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
@Qualifier("google-client")
public class GoogleMapsClient implements AddressProvider {

    private final RestTemplate restTemplate;
    private final String apiKey;

    public GoogleMapsClient(
            RestTemplate restTemplate,
            @Value("${google.api.key}") String apiKey
    ){
            this.restTemplate = restTemplate;
            this.apiKey = apiKey;
    }

    public List<String> searchAddresses(String query) {
        String placesUrl = "https://maps.googleapis.com/maps/api/place/autocomplete/json?input="
                + query + "&key=" + apiKey;
        ResponseEntity<String> response = restTemplate.getForEntity(placesUrl, String.class);

        List<String> addresses = new ArrayList<>();
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(response.getBody());
            JsonNode candidates = jsonNode.path("predictions");

            for (JsonNode candidate : candidates) {
                String description = candidate.path("description").asText();
                addresses.add(description);
            }

        } catch (HttpClientErrorException | HttpServerErrorException e) {
            System.out.println("Erro HTTP: " + e.getStatusCode() + e.getMessage());
        } catch (RestClientException e) {
            System.out.println("Erro de conexão com a API do Google Places " + e.getMessage());
        } catch (JsonProcessingException e) {
            System.out.println("Erro ao processar o JSON da resposta " +e.getMessage() );
        }  catch (Exception e) {
            System.out.println("Erro inesperado " + e.getMessage());
        }
        return addresses;
    }

    public Optional<String> getAddressFromCoordinates(double latitude, double longitude) {
        String url = String.format(
                "https://maps.googleapis.com/maps/api/geocode/json?latlng=%s,%s&key=%s",
                latitude, longitude, apiKey
        );

        try {
            String response = restTemplate.getForObject(url, String.class);
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(response);
            JsonNode results = root.path("results");

            if (results.isArray() && !results.isEmpty()) {
                return Optional.of(results.get(0).path("formatted_address").asText());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }

    public TravelInfo getDistanceAndTimeBetweenTwoAddresses(String origin, String destination) {
        String url = String.format(
                "https://maps.googleapis.com/maps/api/distancematrix/json?origins=%s&destinations=%s&units=metric&key=%s",
                origin, destination, apiKey
        );

        try {
            ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(response.getBody());

            JsonNode elementNode = root.path("rows").get(0).path("elements").get(0);

            double distanceInKm = elementNode.path("distance").path("value").asDouble() / 1000;
            double travelTimeInMinutes = elementNode.path("duration").path("value").asDouble() / 60;

            return new TravelInfo(distanceInKm, travelTimeInMinutes);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao calcular a distância e tempo");
        }
    }


}
