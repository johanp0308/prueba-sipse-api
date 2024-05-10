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

@Entity
@Table(name = "estado")
public class EstadoEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idestado")
    private Long id;

    @Column(nullable = false,length = 255)
    private String descripcion;

    @Column(nullable = false)
    private boolean exitoso;

    @OneToMany(mappedBy = "estado")
    private List<DocumentoEntity> documentos;


    public EstadoEntity() {
    }

    public EstadoEntity(Long id, String descripcion, boolean exitoso, List<DocumentoEntity> documentos) {
        this.id = id;
        this.descripcion = descripcion;
        this.exitoso = exitoso;
        this.documentos = documentos;
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

    public boolean isExitoso() {
        return this.exitoso;
    }

    public boolean getExitoso() {
        return this.exitoso;
    }

    public void setExitoso(boolean exitoso) {
        this.exitoso = exitoso;
    }

    public List<DocumentoEntity> getDocumentos() {
        return this.documentos;
    }

    public void setDocumentos(List<DocumentoEntity> documentos) {
        this.documentos = documentos;
    }

    public EstadoEntity id(Long id) {
        setId(id);
        return this;
    }

    public EstadoEntity descripcion(String descripcion) {
        setDescripcion(descripcion);
        return this;
    }

    public EstadoEntity exitoso(boolean exitoso) {
        setExitoso(exitoso);
        return this;
    }

    public EstadoEntity documentos(List<DocumentoEntity> documentos) {
        setDocumentos(documentos);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof EstadoEntity)) {
            return false;
        }
        EstadoEntity estadoEntity = (EstadoEntity) o;
        return Objects.equals(id, estadoEntity.id) && Objects.equals(descripcion, estadoEntity.descripcion) && exitoso == estadoEntity.exitoso && Objects.equals(documentos, estadoEntity.documentos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, descripcion, exitoso, documentos);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", descripcion='" + getDescripcion() + "'" +
            ", exitoso='" + isExitoso() + "'" +
            ", documentos='" + getDocumentos() + "'" +
            "}";
    }

    
}
