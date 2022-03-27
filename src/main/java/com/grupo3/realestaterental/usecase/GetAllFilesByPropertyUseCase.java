package com.grupo3.realestaterental.usecase;

import com.grupo3.realestaterental.dto.response.GetAllFileByPropertyResponse;
import com.grupo3.realestaterental.service.IFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Jose Manuel Vargas Cruz
 */
@Service
public class GetAllFilesByPropertyUseCase {

    @Autowired
    private IFileService fileService;

    public GetAllFileByPropertyResponse execute(Long propertyId){
        return new GetAllFileByPropertyResponse(
                fileService.findAllByPropertyId(propertyId));
    }
}
