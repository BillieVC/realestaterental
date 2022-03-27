package com.grupo3.realestaterental.repository;

import com.grupo3.realestaterental.domain.File;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Jose Manuel Vargas Cruz
 */
public interface FileRepository extends JpaRepository<File, Long> {
    List<File> findAllByPropertyId(Long propertyId);
}
