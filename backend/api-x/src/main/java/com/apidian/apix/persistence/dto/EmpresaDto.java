package com.apidian.apix.persistence.dto;

import com.apidian.apix.persistence.entities.EmpresaEntity;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmpresaDto {
    
    private Long idempresa;
    private String identificacion;
    private String razonsocial;

    public static EmpresaEntity toEntity(EmpresaDto empresaDto){
        EmpresaEntity eEnt = new EmpresaEntity();
        eEnt.setId(empresaDto.getIdempresa());
        eEnt.setIdentificacion(empresaDto.getIdentificacion());
        eEnt.setRazonsocial(empresaDto.getRazonsocial());

        return eEnt;

    }

    public static EmpresaDto toDto(EmpresaEntity empresaEntity){
        EmpresaDto eDto = new EmpresaDto();
        eDto.setIdempresa(empresaEntity.getId());
        eDto.setIdentificacion(empresaEntity.getIdentificacion());
        eDto.setRazonsocial(empresaEntity.getRazonsocial());
        return eDto;
        
    }


    public EmpresaDto() {
    }

    public EmpresaDto(Long idempresa, String identificacion, String razonsocial) {
        this.idempresa = idempresa;
        this.identificacion = identificacion;
        this.razonsocial = razonsocial;
    }

    public Long getIdempresa() {
        return this.idempresa;
    }

    public void setIdempresa(Long idempresa) {
        this.idempresa = idempresa;
    }

    public String getIdentificacion() {
        return this.identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getRazonsocial() {
        return this.razonsocial;
    }

    public void setRazonsocial(String razonsocial) {
        this.razonsocial = razonsocial;
    }

    public EmpresaDto idempresa(Long idempresa) {
        setIdempresa(idempresa);
        return this;
    }

    public EmpresaDto identificacion(String identificacion) {
        setIdentificacion(identificacion);
        return this;
    }

    public EmpresaDto razonsocial(String razonsocial) {
        setRazonsocial(razonsocial);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof EmpresaDto)) {
            return false;
        }
        EmpresaDto empresaDto = (EmpresaDto) o;
        return Objects.equals(idempresa, empresaDto.idempresa) && Objects.equals(identificacion, empresaDto.identificacion) && Objects.equals(razonsocial, empresaDto.razonsocial);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idempresa, identificacion, razonsocial);
    }

    @Override
    public String toString() {
        return "{" +
            " idempresa='" + getIdempresa() + "'" +
            ", identificacion='" + getIdentificacion() + "'" +
            ", razonsocial='" + getRazonsocial() + "'" +
            "}";
    }
    
}
