package com.apidian.apix.persistence.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.Objects;

import com.apidian.apix.persistence.dto.EmpresaDto;

@Entity
@Table(name = "empresa")
public class EmpresaEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idempresa")
    private Long id;

    @Column(length = 16, nullable = false)
    private String identificacion;

    @Column(nullable = false)
    private String razonsocial;

    @OneToMany(mappedBy = "empresa")
    private List<NumeracionEntity> numeraciones;


    public EmpresaEntity() {
    }

    public EmpresaEntity(Long id, String identificacion, String razonsocial, List<NumeracionEntity> numeraciones) {
        this.id = id;
        this.identificacion = identificacion;
        this.razonsocial = razonsocial;
        this.numeraciones = numeraciones;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<NumeracionEntity> getNumeraciones() {
        return this.numeraciones;
    }

    public void setNumeraciones(List<NumeracionEntity> numeraciones) {
        this.numeraciones = numeraciones;
    }

    public EmpresaEntity id(Long id) {
        setId(id);
        return this;
    }

    public EmpresaEntity identificacion(String identificacion) {
        setIdentificacion(identificacion);
        return this;
    }

    public EmpresaEntity razonsocial(String razonsocial) {
        setRazonsocial(razonsocial);
        return this;
    }

    public EmpresaEntity numeraciones(List<NumeracionEntity> numeraciones) {
        setNumeraciones(numeraciones);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof EmpresaEntity)) {
            return false;
        }
        EmpresaEntity empresaEntity = (EmpresaEntity) o;
        return Objects.equals(id, empresaEntity.id) && Objects.equals(identificacion, empresaEntity.identificacion) && Objects.equals(razonsocial, empresaEntity.razonsocial) && Objects.equals(numeraciones, empresaEntity.numeraciones);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, identificacion, razonsocial, numeraciones);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", identificacion='" + getIdentificacion() + "'" +
            ", razonsocial='" + getRazonsocial() + "'" +
            ", numeraciones='" + getNumeraciones() + "'" +
            "}";
    }
    
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

    public EmpresaDto toDto(){
        EmpresaDto eDto = new EmpresaDto();
        eDto.setIdempresa(this.getId());
        eDto.setIdentificacion(this.getIdentificacion());
        eDto.setRazonsocial(this.getRazonsocial());
        return eDto;
        
    }
}
