package com.grupo3.realestaterental.dto.response;

import com.grupo3.realestaterental.constant.ResponseConstant.StatusCodeResponse;
import com.grupo3.realestaterental.domain.Property;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author Jose Manuel Vargas Cruz
 */
@Getter
@Setter
public class GetAllPropertyResponse extends CommonResponse {

    private List<Property> propertyList;

    public GetAllPropertyResponse(List<Property>propertyList){
        super(StatusCodeResponse.SUCCESS_CODE, StatusCodeResponse.SUCCESS_MSG);
        this.propertyList = propertyList;
    }
}
