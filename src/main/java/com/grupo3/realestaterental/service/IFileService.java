package com.grupo3.realestaterental.service;

import com.grupo3.realestaterental.domain.File;

import java.util.List;

/**
 * @author Jose Manuel Vargas Cruz
 */
public interface IFileService {
    File save(File file);
    File findById(Long fileId);
    List<File> getAll();
    List<File>findAllByPropertyId(Long propertyId);

}
