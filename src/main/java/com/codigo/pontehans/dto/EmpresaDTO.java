package com.codigo.pontehans.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class EmpresaDTO {
//    private Long id;
    private String  razonSocial;
    private String  tipoDocumento;
    private String  numeroDocumento;
    private String  condicion;
    private String  direccion;
    private String  distrito;
    private String  provincia;
    private String  departamento;
    private boolean esAgenteRetencion ;
    private Integer estado;
    private String usuaCrea;
    private Timestamp dateCreate;
    private String usuaModif;
    private Timestamp dateModif;
    private String usuaDelet;
    private Timestamp dateDelet;
}
