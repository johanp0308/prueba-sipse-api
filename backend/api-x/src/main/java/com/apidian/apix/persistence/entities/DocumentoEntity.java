package com.apidian.apix.persistence.entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "documento")
public class DocumentoEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private int numero;
    
    @Column(nullable = false)
    private Date fecha;

    @Column(nullable = false)
    private double base;

    @Column(nullable = false)
    private double impuestos;

    @ManyToOne
    @JoinColumn(name = "idnumeracion",nullable = false)
    private NumeracionEntity numeracion;

    @ManyToOne
    @JoinColumn(name = "idestado", nullable = false)
    private EstadoEntity estado;


    public DocumentoEntity() {
    }

    public DocumentoEntity(Long id, int numero, Date fecha, double base, double impuestos, NumeracionEntity numeracion, EstadoEntity estado) {
        this.id = id;
        this.numero = numero;
        this.fecha = fecha;
        this.base = base;
        this.impuestos = impuestos;
        this.numeracion = numeracion;
        this.estado = estado;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumero() {
        return this.numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Date getFecha() {
        return this.fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getBase() {
        return this.base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getImpuestos() {
        return this.impuestos;
    }

    public void setImpuestos(double impuestos) {
        this.impuestos = impuestos;
    }

    public NumeracionEntity getNumeracion() {
        return this.numeracion;
    }

    public void setNumeracion(NumeracionEntity numeracion) {
        this.numeracion = numeracion;
    }

    public EstadoEntity getEstado() {
        return this.estado;
    }

    public void setEstado(EstadoEntity estado) {
        this.estado = estado;
    }

    public DocumentoEntity id(Long id) {
        setId(id);
        return this;
    }

    public DocumentoEntity numero(int numero) {
        setNumero(numero);
        return this;
    }

    public DocumentoEntity fecha(Date fecha) {
        setFecha(fecha);
        return this;
    }

    public DocumentoEntity base(double base) {
        setBase(base);
        return this;
    }

    public DocumentoEntity impuestos(double impuestos) {
        setImpuestos(impuestos);
        return this;
    }

    public DocumentoEntity numeracion(NumeracionEntity numeracion) {
        setNumeracion(numeracion);
        return this;
    }

    public DocumentoEntity estado(EstadoEntity estado) {
        setEstado(estado);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof DocumentoEntity)) {
            return false;
        }
        DocumentoEntity documentoEntity = (DocumentoEntity) o;
        return Objects.equals(id, documentoEntity.id) && numero == documentoEntity.numero && Objects.equals(fecha, documentoEntity.fecha) && base == documentoEntity.base && impuestos == documentoEntity.impuestos && Objects.equals(numeracion, documentoEntity.numeracion) && Objects.equals(estado, documentoEntity.estado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, numero, fecha, base, impuestos, numeracion, estado);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", numero='" + getNumero() + "'" +
            ", fecha='" + getFecha() + "'" +
            ", base='" + getBase() + "'" +
            ", impuestos='" + getImpuestos() + "'" +
            ", numeracion='" + getNumeracion() + "'" +
            ", estado='" + getEstado() + "'" +
            "}";
    }
    
}
