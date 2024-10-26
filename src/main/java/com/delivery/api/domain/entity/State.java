package com.delivery.api.domain.entity;

import java.util.ArrayList;
import java.util.List;

public class State {

    private Long id;
    private String name;
    private List<City> cities = new ArrayList<>();

    public State(){}

    public State(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public void addCity(City city){
        this.cities.add(city);
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

    public List<City> getCities() {
        return cities;
    }

}
