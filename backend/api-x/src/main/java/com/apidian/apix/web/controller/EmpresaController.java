package com.apidian.apix.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apidian.apix.domain.service.EmpresasService;
import com.apidian.apix.persistence.dto.EmpresaDto;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("/empresa")
@SecurityRequirement(name = "bearerAuth")
public class EmpresaController {

    private final EmpresasService empresasService;

    @Autowired
    public EmpresaController(EmpresasService empresasService) {
        this.empresasService = empresasService;
    }

    @GetMapping("/")
    public List<EmpresaDto> getMethodName() {
        return empresasService.getAll();
    }

    @PostMapping("/")
    public EmpresaDto postMethodName(@RequestBody EmpresaDto dto) {
        return empresasService.save(dto);
    }

    @DeleteMapping("/{id}")
    public Map<String,Object> deleteMethod(@PathVariable String id){
        Map<String,Object> response = new HashMap<>();
        try {
            
            empresasService.deletebyID(Long.valueOf(id));
            response.put("Elminado", id);
        } catch (Exception e) {
            response.put("Error", id);
        }
        return response;
    }

    @PutMapping("/{id}")
    public Map<String,Object> putMethodName(@PathVariable String id, @RequestBody EmpresaDto entity) {
        Map<String,Object> response = new HashMap<>();
        try {
            EmpresaDto empresa =  empresasService.update(Long.valueOf(id),entity);
            response.put("Editado", empresa);
        } catch (Exception e) {
            response.put("Error", id);
        }
        return response;
    }
    
    
    
}
