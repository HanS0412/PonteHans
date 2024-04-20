package com.codigo.pontehans.entity;

import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class Auditoria {

    private String usuaCrea;
//    @Temporal(TemporalType.DATE)
    private Timestamp dateCreate;
    private String usuaModif;
//    @Temporal(TemporalType.DATE)
    private Timestamp dateModif;
    private String usuaDelet;
//    @Temporal(TemporalType.DATE)
    private Timestamp dateDelet;

}
