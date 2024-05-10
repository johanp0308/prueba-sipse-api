package com.apidian.apix.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apidian.apix.persistence.entities.NumeracionEntity;

public interface NumeracionRepository extends JpaRepository<NumeracionEntity,Long>{
    
}
