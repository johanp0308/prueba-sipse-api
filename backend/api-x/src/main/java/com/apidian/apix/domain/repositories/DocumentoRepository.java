package com.apidian.apix.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apidian.apix.persistence.entities.DocumentoEntity;

public interface DocumentoRepository extends JpaRepository<DocumentoEntity,Long>{
    
}
