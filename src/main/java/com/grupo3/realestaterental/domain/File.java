package com.grupo3.realestaterental.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = TableConstants.FileTable.NAME)
public class File {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String mimeType;

    @Column
    private String name;

    @Column
    private Long size;

    @Column
    @Lob
    private byte[] value;

    @Column
    private Long propertyId;
}
