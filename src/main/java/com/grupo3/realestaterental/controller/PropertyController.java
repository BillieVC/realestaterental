package com.grupo3.realestaterental.controller;

import com.grupo3.realestaterental.domain.Property;
import com.grupo3.realestaterental.dto.response.SavedPropertyResponse;
import com.grupo3.realestaterental.usecase.CreatePropertyUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/property")
public class PropertyController {
    @Autowired
    private CreatePropertyUseCase createPropertyUseCase;

    @PostMapping("")
    public SavedPropertyResponse saveProperty(@RequestBody Property property){
        return createPropertyUseCase.execute(property);
    }
}
