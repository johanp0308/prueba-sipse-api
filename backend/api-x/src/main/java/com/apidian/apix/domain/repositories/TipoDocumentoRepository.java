package com.apidian.apix.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apidian.apix.persistence.entities.TipoDocumentoEntity;

public interface TipoDocumentoRepository extends JpaRepository<TipoDocumentoEntity,Long>{
    
}
