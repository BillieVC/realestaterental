package com.grupo3.realestaterental.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author Jose Manuel Vargas Cruz
 */
@Getter
@Setter
public class PropertyRequest {

    private double price;

    private String description;

    private String zone;

    private String contactInfo;

    private Date publicationDate;
}
