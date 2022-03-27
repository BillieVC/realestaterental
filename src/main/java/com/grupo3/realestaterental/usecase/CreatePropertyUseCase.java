package com.grupo3.realestaterental.usecase;

import com.grupo3.realestaterental.domain.Property;
import com.grupo3.realestaterental.dto.request.PropertyRequest;
import com.grupo3.realestaterental.dto.response.SavedPropertyResponse;
import com.grupo3.realestaterental.service.IPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CreatePropertyUseCase {
    @Autowired
    private IPropertyService propertyService;

    public SavedPropertyResponse execute(PropertyRequest propertyRequest) {
        return new SavedPropertyResponse(
                propertyService.save(buildProperty(propertyRequest)));
    }

    private Property buildProperty(PropertyRequest propertyRequest) {
        Property property = new Property();
        property.setPrice(propertyRequest.getPrice());
        property.setContactInfo(propertyRequest.getContactInfo());
        property.setDescription(propertyRequest.getDescription());
        property.setPublicationDate(propertyRequest.getPublicationDate());
        property.setZone(propertyRequest.getZone());

        return property;
    }
}
