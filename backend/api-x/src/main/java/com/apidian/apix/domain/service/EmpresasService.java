package com.apidian.apix.domain.service;

import java.util.List;
import java.util.Map;

import com.apidian.apix.persistence.dto.EmpresaDto;

public interface EmpresasService {
    
    List<EmpresaDto> getAll();
    EmpresaDto getById(Long id);
    EmpresaDto save(EmpresaDto edto);
    void deletebyID(Long id);
    EmpresaDto update(Long id, EmpresaDto empresaDto);

    List<Map<String, Object>> getEmpresasDocumentosMoreFallidosThanExitosos();
    List<Map<String, Object>> countDocumentosByPrefijoAndFecha(String fechaInicio, String fechaFin);
    List<Map<String, Object>> countDocumentosByEstado();
    List<Map<String, Object>> getEmpresasConMasTresDocumentosNoExitosos();
    List<Map<String, Object>> countDocumentosFueraRangoVigencia();
    List<Map<String, Object>> calcularTotalDineroRecibido();
    List<Map<String, Object>> encontrarNumerosCompletosRepetidos();
}
