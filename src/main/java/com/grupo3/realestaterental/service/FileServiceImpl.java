package com.grupo3.realestaterental.service;

import com.grupo3.realestaterental.domain.File;
import com.grupo3.realestaterental.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Jose Manuel Vargas Cruz
 */
@Service
public class FileServiceImpl implements IFileService {
    @Autowired
    private FileRepository fileRepository;

    @Override
    public File save(File file) {

        return fileRepository.save(file);

    }

    @Override
    public File findById(Long fileId) {
        return fileRepository.findById(fileId)
                .orElseThrow(() ->
                        new RuntimeException("Unable to locate file by fileID "
                                + fileId));
    }

    @Override
    public List<File> getAll() {
        return fileRepository.findAll();
    }

    @Override
    public List<File> findAllByPropertyId(Long propertyId) {
        return fileRepository.findAllByPropertyId(propertyId);
    }
}
