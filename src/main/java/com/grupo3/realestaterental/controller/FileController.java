package com.grupo3.realestaterental.controller;

import com.grupo3.realestaterental.dto.response.FileDownloadResponse;
import com.grupo3.realestaterental.dto.response.FileResponse;
import com.grupo3.realestaterental.dto.response.GetAllFileByPropertyResponse;
import com.grupo3.realestaterental.usecase.CreateFileUseCase;
import com.grupo3.realestaterental.usecase.DownloadFileUseCase;
import com.grupo3.realestaterental.usecase.GetAllFilesByPropertyUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

@RestController()
@RequestMapping("/files")
public class FileController {
    @Autowired
    private GetAllFilesByPropertyUseCase getAllFilesByPropertyUseCase;

    @Autowired
    private DownloadFileUseCase downloadFileUseCase;

    @Autowired
    private CreateFileUseCase createFileUseCase;

    @GetMapping("/{propertyId}")
    public GetAllFileByPropertyResponse getAllFileByProperty
            (@PathVariable Long propertyId){
        return getAllFilesByPropertyUseCase.execute(propertyId);
    }

    @GetMapping(value = "/download/{fileId}")
    public ResponseEntity<InputStreamResource> downloadFile(@PathVariable("fileId") Long fileId) {
        FileDownloadResponse response = downloadFileUseCase.execute(fileId);
        InputStream content = new ByteArrayInputStream(response.getBytes(), 0, response.getBytes().length);

        return ResponseEntity
                .ok()
                .header(HttpHeaders.CONTENT_DISPOSITION)
                .contentType(MediaType.parseMediaType(response.getMimeType()))
                .body(new InputStreamResource(content));
    }

    @PostMapping(value = "/upload/{propertyId}", consumes = "multipart/form-data")
    public FileResponse uploadPropertyPhoto(@RequestPart MultipartFile multipartFile,
                                            @PathVariable Long propertyId) {
        return createFileUseCase.execute(multipartFile, propertyId);
    }
}
