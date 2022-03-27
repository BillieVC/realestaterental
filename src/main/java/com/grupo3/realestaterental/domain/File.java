package com.grupo3.realestaterental.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Table
public class File {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private String id;

    private String mimeType;

    private String name;

    private Long size;

    private byte[] value;

    @ManyToOne
    private Long propertyId;
}
