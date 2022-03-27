package com.grupo3.realestaterental.repository;

import com.grupo3.realestaterental.domain.Property;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertyRepository extends JpaRepository<Property, Long> {
}
