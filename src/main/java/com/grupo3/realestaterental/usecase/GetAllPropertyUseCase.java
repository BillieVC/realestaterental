package com.grupo3.realestaterental.usecase;

import com.grupo3.realestaterental.dto.response.GetAllPropertyResponse;
import com.grupo3.realestaterental.service.IPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Jose Manuel Vargas Cruz
 */
@Service
public class GetAllPropertyUseCase {

    @Autowired
    private IPropertyService propertyService;

    public GetAllPropertyResponse execute(){
        return new GetAllPropertyResponse(propertyService.getAll());
    }
}
