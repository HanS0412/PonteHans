package com.codigo.pontehans.dto;

import com.codigo.pontehans.entity.Empresa;

import java.util.List;
import java.util.Optional;

public class ConverEntityToDTO {
    public EmpresaDTO getDto(Empresa e){
        return EmpresaDTO.builder()
                .razonSocial(e.getRazonSocial())
                .tipoDocumento(e.getTipoDocumento())
                .numeroDocumento(e.getNumeroDocumento())
                .condicion(e.getCondicion())
                .direccion(e.getDireccion())
                .provincia(e.getProvincia())
                .distrito(e.getDistrito())
                .departamento(e.getDepartamento())
                .esAgenteRetencion(e.isEsAgenteRetencion())
                .estado(e.getEstado())
                .usuaCrea(e.getUsuaCrea())
                .dateCreate(e.getDateCreate())
                .usuaModif(e.getUsuaModif())
                .dateModif(e.getDateModif())
                .usuaDelet(e.getUsuaDelet())
                .dateDelet(e.getDateDelet())
                .build();
    }
    public List<EmpresaDTO> getListDto(List<Empresa> e){
        return e.stream().map(x -> getDto(x)).toList();
    }
    public Optional<EmpresaDTO> getDtoOptional(Empresa e){
        return Optional.ofNullable(EmpresaDTO.builder()
                .razonSocial(e.getRazonSocial())
                .tipoDocumento(e.getTipoDocumento())
                .numeroDocumento(e.getNumeroDocumento())
                .condicion(e.getCondicion())
                .direccion(e.getDireccion())
                .provincia(e.getProvincia())
                .distrito(e.getDistrito())
                .departamento(e.getDepartamento())
                .esAgenteRetencion(e.isEsAgenteRetencion())
                .estado(e.getEstado())
                .usuaCrea(e.getUsuaCrea())
                .dateCreate(e.getDateCreate())
                .usuaModif(e.getUsuaModif())
                .dateModif(e.getDateModif())
                .usuaDelet(e.getUsuaDelet())
                .dateDelet(e.getDateDelet())
                .build());
    }
}
