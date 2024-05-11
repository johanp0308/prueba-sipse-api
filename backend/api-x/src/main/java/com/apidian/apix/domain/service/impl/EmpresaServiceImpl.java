package com.apidian.apix.domain.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apidian.apix.domain.excepciones.NotFoundItemExcecion;
import com.apidian.apix.domain.repositories.EmpresaRepository;
import com.apidian.apix.domain.service.EmpresasService;
import com.apidian.apix.persistence.dto.EmpresaDto;
import com.apidian.apix.persistence.entities.EmpresaEntity;

@Service
public class EmpresaServiceImpl implements EmpresasService{

    private final EmpresaRepository empresaRepository;

    @Autowired
    public EmpresaServiceImpl(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }
    
    @Override
    public List<EmpresaDto> getAll() {
        List<EmpresaDto> dtoList = new ArrayList<>();
        empresaRepository.findAll().stream().forEach(ele -> dtoList.add( ele.toDto() ));
        return dtoList;
        // throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

    @Override
    public EmpresaDto getById(Long id) {
        EmpresaEntity empresaEntity = empresaRepository.findById(id).orElse(null);
        if (empresaEntity != null) {
            return empresaEntity.toDto();
        }
        throw new NotFoundItemExcecion("No se encontro la Empresa con id: "+id);
    }

    @Override
    public EmpresaDto save(EmpresaDto edto) {
        EmpresaEntity empresaEntity = edto.toEntity(edto);
        EmpresaEntity response = empresaRepository.save(empresaEntity);
        return response.toDto();
    }

    @Override
    public void deletebyID(Long id) {
        empresaRepository.deleteById(id);
    }

    @Override
    public EmpresaDto update(Long id, EmpresaDto empresaDto) {
        EmpresaEntity empresaEntity = empresaDto.toEntity(empresaDto);
        empresaEntity.setId(id);
        empresaRepository.save(empresaEntity);
        return empresaDto;
    }

    @Override
    public List<Map<String, Object>> getEmpresasDocumentosMoreFallidosThanExitosos() {
        List<Object[]> results = empresaRepository.findEmpresasDocumentosMoreFallidosThanExitosos();
        List<Map<String, Object>> response = new ArrayList<>();

        for (Object[] row : results) {
            Map<String, Object> info = new HashMap<>();
            info.put("idempresa", row[0]);
            info.put("razonsocial", row[1]);
            info.put("exitosos", row[2]);
            info.put("fallidos", row[3]);
            response.add(info);
        }

        return response;
    }

    @Override
    public List<Map<String, Object>> countDocumentosByPrefijoAndFecha(String fechaInicio, String fechaFin) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'countDocumentosByPrefijoAndFecha'");
    }

    @Override
    public List<Map<String, Object>> countDocumentosByEstado() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'countDocumentosByEstado'");
    }

    @Override
    public List<Map<String, Object>> getEmpresasConMasTresDocumentosNoExitosos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getEmpresasConMasTresDocumentosNoExitosos'");
    }

    @Override
    public List<Map<String, Object>> countDocumentosFueraRangoVigencia() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'countDocumentosFueraRangoVigencia'");
    }

    @Override
    public List<Map<String, Object>> calcularTotalDineroRecibido() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'calcularTotalDineroRecibido'");
    }

    @Override
    public List<Map<String, Object>> encontrarNumerosCompletosRepetidos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'encontrarNumerosCompletosRepetidos'");
    }

    
    
    

}
