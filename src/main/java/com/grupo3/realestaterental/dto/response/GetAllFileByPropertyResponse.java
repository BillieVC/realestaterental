package com.grupo3.realestaterental.dto.response;

import com.grupo3.realestaterental.constant.ResponseConstant.StatusCodeResponse;
import com.grupo3.realestaterental.domain.File;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author Jose Manuel Vargas Cruz
 */
@Getter
@Setter
public class GetAllFileByPropertyResponse extends CommonResponse {
    private List<File> files;

    public GetAllFileByPropertyResponse(List<File> files) {
        super(StatusCodeResponse.SUCCESS_CODE, StatusCodeResponse.SUCCESS_MSG);
        this.files = files;
    }
}
