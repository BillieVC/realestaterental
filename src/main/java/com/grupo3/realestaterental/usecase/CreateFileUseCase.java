package com.grupo3.realestaterental.usecase;

import com.grupo3.realestaterental.domain.File;
import com.grupo3.realestaterental.dto.response.FileResponse;
import com.grupo3.realestaterental.service.IFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author Jose Manuel Vargas Cruz
 */
@Service
public class CreateFileUseCase {
    @Autowired
    private IFileService fileService;

    public FileResponse execute(MultipartFile multipartFile, Long propertyId) {
        File saved = fileService.save(buildFile(multipartFile, propertyId));
        return new FileResponse(saved);
    }

    private File buildFile(MultipartFile multipartFile, Long propertyId) {
        File instance = new File();
        instance.setName(multipartFile.getOriginalFilename());
        instance.setMimeType(multipartFile.getContentType());
        instance.setSize(multipartFile.getSize());
        instance.setPropertyId(propertyId);
        try {
            instance.setValue(multipartFile.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("It's not possible to save FileData");
        }
        return instance;
    }

}
