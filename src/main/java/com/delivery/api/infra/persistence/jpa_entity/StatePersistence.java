package com.delivery.api.infra.persistence.jpa_entity;

import com.delivery.api.domain.entity.State;
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

    public static StatePersistence convertStateToStatePersistence(State state) {
        return new StatePersistence(state.getId(), state.getName());
    }

    public static State convertStatePersistenceToState(StatePersistence statePersistence) {
        return new State(statePersistence.getId(), statePersistence.getName());
    }

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
