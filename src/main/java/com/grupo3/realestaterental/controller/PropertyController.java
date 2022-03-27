package com.grupo3.realestaterental.controller;

import com.grupo3.realestaterental.dto.request.PropertyRequest;
import com.grupo3.realestaterental.dto.response.FileResponse;
import com.grupo3.realestaterental.dto.response.GetAllFileByPropertyResponse;
import com.grupo3.realestaterental.dto.response.GetAllPropertyResponse;
import com.grupo3.realestaterental.dto.response.SavedPropertyResponse;
import com.grupo3.realestaterental.usecase.CreateFileUseCase;
import com.grupo3.realestaterental.usecase.CreatePropertyUseCase;
import com.grupo3.realestaterental.usecase.GetAllFilesByPropertyUseCase;
import com.grupo3.realestaterental.usecase.GetAllPropertyUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/property")
public class PropertyController {
    @Autowired
    private CreatePropertyUseCase createPropertyUseCase;

    @Autowired
    private CreateFileUseCase createFileUseCase;

    @Autowired
    private GetAllPropertyUseCase getAllPropertyUseCase;

    @Autowired
    private GetAllFilesByPropertyUseCase getAllFilesByPropertyUseCase;

    @PostMapping()
    public SavedPropertyResponse saveProperty(
            @RequestBody PropertyRequest propertyRequest) {

        return createPropertyUseCase.execute(propertyRequest);
    }

    @PostMapping(value = "uploadPhoto/{propertyId}", consumes = "multipart/form-data")
    public FileResponse uploadPropertyPhoto(@RequestPart MultipartFile multipartFile,
                                            @PathVariable Long propertyId) {
        return createFileUseCase.execute(multipartFile, propertyId);
    }

    @GetMapping
    public GetAllPropertyResponse getAllProperty(){
        return getAllPropertyUseCase.execute();
    }

    @GetMapping("/{propertyId}")
    public GetAllFileByPropertyResponse getAllFileByProperty
            (@PathVariable Long propertyId){
        return getAllFilesByPropertyUseCase.execute(propertyId);
    }

}
