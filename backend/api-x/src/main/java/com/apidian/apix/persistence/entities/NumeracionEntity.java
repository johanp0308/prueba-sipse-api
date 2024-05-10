package com.apidian.apix.persistence.entities;

import java.util.Date;

import org.apache.naming.java.javaURLContextFactory;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "numeracion")
public class NumeracionEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idnumeracion")
    private Long id;


    @Column(nullable = false, length = 8)
    private String prefijo;

    @Column(nullable = false)
    private int consecutivoinicial;

    @Column(nullable = false)
    private int consecutivofinal;

    @Column(nullable = false)
    private Date vigenciainicial;

    @Column(nullable = false)
    private Date vigenciafinal;


    @ManyToOne()
    @JoinColumn(name = "idempresa", nullable = false)
    private EmpresaEntity empresa;

    @ManyToOne()
    @JoinColumn(name = "idtipodocumento", nullable = false)
    private TipoDocumentoEntity tipoDocumento;


}
