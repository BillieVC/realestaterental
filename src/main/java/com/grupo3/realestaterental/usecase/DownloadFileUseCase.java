package com.grupo3.realestaterental.usecase;

import com.grupo3.realestaterental.domain.File;
import com.grupo3.realestaterental.dto.response.FileDownloadResponse;
import com.grupo3.realestaterental.service.IFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DownloadFileUseCase {
    @Autowired
    private IFileService fileService;

    public FileDownloadResponse execute(Long fileId) {
        File file = fileService.findById(fileId);


        return buildFileDownloadResponse(file);
    }

    private FileDownloadResponse buildFileDownloadResponse(File file) {
        FileDownloadResponse instance = new FileDownloadResponse();

        instance.setName(file.getName());
        instance.setMimeType(file.getMimeType());
        instance.setSize(file.getSize());
        instance.setBytes(file.getValue());

        return instance;
    }


}
