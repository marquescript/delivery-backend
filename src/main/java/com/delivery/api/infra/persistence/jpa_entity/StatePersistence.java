package com.delivery.api.infra.persistence.jpa_entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "state")
public class StatePersistence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "statePersistence", cascade = CascadeType.ALL)
    List<CityPersistence> cityPersistences = new ArrayList<>();

    public StatePersistence(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public StatePersistence() {}

    public void addCityPersistence(CityPersistence cityPersistence) {
        this.cityPersistences.add(cityPersistence);
    }

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

    public List<CityPersistence> getCityPersistences() {
        return cityPersistences;
    }

}
