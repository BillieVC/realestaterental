package com.grupo3.realestaterental.controller;

import com.grupo3.realestaterental.dto.request.PropertyRequest;
import com.grupo3.realestaterental.dto.response.GetAllPropertyResponse;
import com.grupo3.realestaterental.dto.response.SavedPropertyResponse;
import com.grupo3.realestaterental.usecase.CreatePropertyUseCase;
import com.grupo3.realestaterental.usecase.GetAllPropertyUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/property")
public class PropertyController {
    @Autowired
    private CreatePropertyUseCase createPropertyUseCase;

    @Autowired
    private GetAllPropertyUseCase getAllPropertyUseCase;

    @PostMapping()
    public SavedPropertyResponse saveProperty(
            @RequestBody PropertyRequest propertyRequest) {

        return createPropertyUseCase.execute(propertyRequest);
    }

    @GetMapping
    public GetAllPropertyResponse getAllProperty() {
        return getAllPropertyUseCase.execute();
    }


}
