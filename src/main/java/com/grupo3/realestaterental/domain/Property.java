package com.grupo3.realestaterental.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;


@Getter
@Setter
@Table(name = TableConstants.PropertyTable.NAME)
public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = TableConstants.PropertyTable.Id.NAME)
    private Long id;

    @Column(name = TableConstants.PropertyTable.Price.NAME)
    private double price;

    @Column(name = TableConstants.PropertyTable.Description.NAME,
            length = TableConstants.PropertyTable.Description.LENGTH)
    private String description;

    @Column(name = TableConstants.PropertyTable.Zone.NAME,
            length = TableConstants.PropertyTable.Zone.LENGTH)
    private String zone;

    @Column(name = TableConstants.PropertyTable.ContactInfo.NAME,
            length = TableConstants.PropertyTable.ContactInfo.LENGTH)
    private String contactInfo;

    @Temporal(TemporalType.DATE)
    @Column(name = TableConstants.PropertyTable.PublicationDate.NAME)
    private Date publicationDate;



}
