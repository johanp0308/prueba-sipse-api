package com.apidian.apix.persistence.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tipodocumento")
public class TipoDocumentoEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idtipodocumento")
    private Long id;

    @Column(nullable = false, length = 255)
    private String descripcion;

    @OneToMany(mappedBy = "tipodocumento", cascade = CascadeType.ALL)
    private List<NumeracionEntity> numeraciones;

    public TipoDocumentoEntity() {
    }

    public TipoDocumentoEntity(Long id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public TipoDocumentoEntity id(Long id) {
        setId(id);
        return this;
    }

    public TipoDocumentoEntity descripcion(String descripcion) {
        setDescripcion(descripcion);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof TipoDocumentoEntity)) {
            return false;
        }
        TipoDocumentoEntity tipoDocumentoEntity = (TipoDocumentoEntity) o;
        return Objects.equals(id, tipoDocumentoEntity.id) && Objects.equals(descripcion, tipoDocumentoEntity.descripcion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, descripcion);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", descripcion='" + getDescripcion() + "'" +
            "}";
    }

    
}
