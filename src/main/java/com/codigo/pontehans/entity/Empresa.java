package com.codigo.pontehans.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Empresa extends Auditoria{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long	id ;
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

}
