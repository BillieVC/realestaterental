package com.grupo3.realestaterental.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FileDownloadResponse {
    private String mimeType;

    private String name;

    private Long size;

    private byte[] bytes;

}
