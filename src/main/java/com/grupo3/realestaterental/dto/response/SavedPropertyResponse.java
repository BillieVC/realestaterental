package com.grupo3.realestaterental.dto.response;

import com.grupo3.realestaterental.constant.ResponseConstant.StatusCodeResponse;
import com.grupo3.realestaterental.domain.Property;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SavedPropertyResponse extends CommonResponse{
    private Property property;

    public SavedPropertyResponse(Property property){
        super(StatusCodeResponse.SUCCESS_CODE,StatusCodeResponse.SUCCESS_MSG);
        this.property=property;
    }
}
