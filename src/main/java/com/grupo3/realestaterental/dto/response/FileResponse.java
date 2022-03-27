package com.grupo3.realestaterental.dto.response;

import com.grupo3.realestaterental.constant.ResponseConstant.StatusCodeResponse;
import com.grupo3.realestaterental.domain.File;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Jose Manuel Vargas Cruz
 */
@Getter
@Setter
public class FileResponse extends CommonResponse {
    private File file;

    public FileResponse (File file){
        super(StatusCodeResponse.SUCCESS_CODE, StatusCodeResponse.SUCCESS_MSG);
        this.file = file;
    }

}
