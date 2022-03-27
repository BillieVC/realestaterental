package com.grupo3.realestaterental.service;

import com.grupo3.realestaterental.domain.Property;

import java.util.List;

public interface IPropertyService {
    Property save (Property property);
    List<Property> getAll();
    Property findById (Long id);
    void deleteById(Long id);
}
