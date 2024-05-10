package com.apidian.apix.persistence.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

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
}
