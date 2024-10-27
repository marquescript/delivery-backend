package com.delivery.api.infra.persistence.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "address")
public class AddressPersistence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cep;

    @Column(name = "public_place")
    private String publicPlace;

    private String number;

    private String complement;

    private String neighborhood;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "city_id")
    private CityPersistence cityPersistence;

    public AddressPersistence(Long id, String cep, String publicPlace, String number, String complement, String neighborhood, CityPersistence cityPersistence) {
        this.id = id;
        this.cep = cep;
        this.publicPlace = publicPlace;
        this.number = number;
        this.complement = complement;
        this.neighborhood = neighborhood;
        this.cityPersistence = cityPersistence;
    }

    public AddressPersistence() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getPublicPlace() {
        return publicPlace;
    }

    public void setPublicPlace(String publicPlace) {
        this.publicPlace = publicPlace;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public CityPersistence getCityPersistence() {
        return cityPersistence;
    }

    public void setCityPersistence(CityPersistence cityPersistence) {
        this.cityPersistence = cityPersistence;
    }
}
