package com.delivery.api.infra.http.dto;

public record TravelInfo(
        double distanceInKm,
        double travelTimeInMinutes
) {
}
