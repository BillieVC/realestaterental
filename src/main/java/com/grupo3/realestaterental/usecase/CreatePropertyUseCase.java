package com.grupo3.realestaterental.usecase;

import com.grupo3.realestaterental.domain.Property;
import com.grupo3.realestaterental.dto.response.SavedPropertyResponse;
import com.grupo3.realestaterental.service.IPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CreatePropertyUseCase {
    @Autowired
    private IPropertyService propertyService;

    public SavedPropertyResponse execute(Property property){
        return new SavedPropertyResponse(
                propertyService.save(property)
        );
    }
}
