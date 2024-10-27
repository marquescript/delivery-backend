package com.delivery.api.infra.persistence.jpa_entity;

import com.delivery.api.domain.entity.City;
import jakarta.persistence.*;

@Entity
@Table(name = "city")
public class CityPersistence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "state_id")
    private StatePersistence statePersistence;

    public CityPersistence(Long id, String name, StatePersistence statePersistence) {
        this.id = id;
        this.name = name;
        this.statePersistence = statePersistence;
    }

    public static CityPersistence convertCityToCityPersistence(City city) {
        return new CityPersistence(
                city.getId(),
                city.getName(),
                StatePersistence.convertStateToStatePersistence(city.getState())
        );
    }

    public static City convertCityPersistenceToCity(CityPersistence cityPersistence) {
        return new City(
                cityPersistence.getId(),
                cityPersistence.getName(),
                StatePersistence.convertStatePersistenceToState(cityPersistence.getStatePersistence())
        );
    }

    public CityPersistence() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public StatePersistence getStatePersistence() {
        return statePersistence;
    }

    public void setStatePersistence(StatePersistence statePersistence) {
        this.statePersistence = statePersistence;
    }
}
