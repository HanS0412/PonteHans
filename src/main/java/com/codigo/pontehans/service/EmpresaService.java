package com.codigo.pontehans.service;

import com.codigo.pontehans.dto.EmpresaDTO;
import com.codigo.pontehans.request.EmpresaRequest;

import java.util.List;
import java.util.Optional;

public interface EmpresaService {
    EmpresaDTO crearEmpresa(EmpresaRequest empresaRequest);
    Optional<EmpresaDTO> obtenerEmpresa(Long id);
    List<EmpresaDTO> obtenerEmpresas();
    EmpresaDTO actualizarEmpresa(Long id, EmpresaRequest empresaRequest);
    EmpresaDTO deleteEmpresa(Long id);
}
