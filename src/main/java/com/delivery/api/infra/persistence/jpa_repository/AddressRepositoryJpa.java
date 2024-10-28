package com.delivery.api.infra.persistence.jpa_repository;

import com.delivery.api.domain.repository.AddressRepository;
import com.delivery.api.infra.persistence.jpa_entity.AddressPersistence;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Qualifier("jpa")
public interface AddressRepositoryJpa extends JpaRepository<AddressPersistence, Long>, AddressRepository<AddressPersistence> {



}
