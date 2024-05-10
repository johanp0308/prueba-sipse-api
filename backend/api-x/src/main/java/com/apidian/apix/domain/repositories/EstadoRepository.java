package com.apidian.apix.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apidian.apix.persistence.entities.EstadoEntity;

public interface EstadoRepository extends JpaRepository<EstadoEntity,Long>{
    
}
