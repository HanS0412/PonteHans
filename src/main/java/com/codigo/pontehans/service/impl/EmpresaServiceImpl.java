package com.codigo.pontehans.service.impl;

import com.codigo.pontehans.constants.Constants;
import com.codigo.pontehans.dao.EmpresaRepository;
import com.codigo.pontehans.dto.ConverEntityToDTO;
import com.codigo.pontehans.dto.EmpresaDTO;
import com.codigo.pontehans.entity.Empresa;
import com.codigo.pontehans.request.EmpresaRequest;
import com.codigo.pontehans.service.EmpresaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EmpresaServiceImpl implements EmpresaService {

    private final EmpresaRepository empresaRepository;
    @Override
    public EmpresaDTO crearEmpresa(EmpresaRequest empresaRequest) {
        Empresa nuevaEmpresa = new Empresa();
        nuevaEmpresa.setRazonSocial(empresaRequest.getRazonSocial());
        nuevaEmpresa.setTipoDocumento(empresaRequest.getTipoDocumento());
        nuevaEmpresa.setNumeroDocumento(empresaRequest.getNumeroDocumento());
        nuevaEmpresa.setCondicion(empresaRequest.getCondicion());
        nuevaEmpresa.setDireccion(empresaRequest.getDireccion());
        nuevaEmpresa.setDistrito(empresaRequest.getDistrito());
        nuevaEmpresa.setProvincia(empresaRequest.getProvincia());
        nuevaEmpresa.setDepartamento(empresaRequest.getDepartamento());
        nuevaEmpresa.setEsAgenteRetencion(empresaRequest.isEsAgenteRetencion());
        nuevaEmpresa.setEstado(empresaRequest.getEstado());
        nuevaEmpresa.setUsuaCrea(Constants.userCreate);
        nuevaEmpresa.setDateCreate(getTimestamp());
        empresaRepository.save(nuevaEmpresa);
        ConverEntityToDTO dto = new ConverEntityToDTO();
        return dto.getDto(nuevaEmpresa);
    }

    private Timestamp getTimestamp(){
        long currentTime = System.currentTimeMillis();
        return new Timestamp(currentTime);
    }

    @Override
    public Optional<EmpresaDTO> obtenerEmpresa(Long id) {
        Optional<Empresa> empresa = empresaRepository.findById(id);
        if(empresa.isPresent()){
            ConverEntityToDTO dto = new ConverEntityToDTO();
            Optional<EmpresaDTO> op = dto.getDtoOptional(empresa.get());
            return op;
        }
        return Optional.empty();
    }

    @Override
    public List<EmpresaDTO> obtenerEmpresas() {
        List<Empresa> empresas = empresaRepository.findAll();
        if(!empresas.isEmpty()){
            ConverEntityToDTO dto = new ConverEntityToDTO();
            return dto.getListDto(empresas);
        }
        return null;
    }

    @Override
    public EmpresaDTO actualizarEmpresa(Long id, EmpresaRequest empresaRequest) {
        Optional<Empresa> empresa = empresaRepository.findById(id);
        if(empresa.isPresent()){
            Empresa empresaUpdate = empresa.get();
            ConverEntityToDTO dto = new ConverEntityToDTO();
            empresaUpdate.setRazonSocial(empresaRequest.getRazonSocial());
            empresaUpdate.setTipoDocumento(empresaRequest.getTipoDocumento());
            empresaUpdate.setNumeroDocumento(empresaRequest.getNumeroDocumento());
            empresaUpdate.setCondicion(empresaRequest.getCondicion());
            empresaUpdate.setDireccion(empresaRequest.getDireccion());
            empresaUpdate.setDistrito(empresaRequest.getDistrito());
            empresaUpdate.setProvincia(empresaRequest.getProvincia());
            empresaUpdate.setDepartamento(empresaRequest.getDepartamento());
            empresaUpdate.setEsAgenteRetencion(empresaRequest.isEsAgenteRetencion());
            empresaUpdate.setEstado(empresaRequest.getEstado());
            empresaUpdate.setUsuaModif(Constants.userUpdate);
            empresaUpdate.setDateModif(getTimestamp());
            empresaRepository.save(empresaUpdate);
            return dto.getDto(empresaUpdate);
        }
        return null;
    }

    @Override
    public EmpresaDTO deleteEmpresa(Long id) {
        Optional<Empresa> empresa = empresaRepository.findById(id);
        if(empresa.isPresent()){
            Empresa empresaUpdate = empresa.get();
            empresaUpdate.setEstado(0);
            empresaUpdate.setUsuaDelet(Constants.userDelete);
            empresaUpdate.setDateDelet(getTimestamp());
            ConverEntityToDTO dto = new ConverEntityToDTO();
            empresaRepository.save(empresaUpdate);
            return dto.getDto(empresaUpdate);
        }
        return null;
    }
}
