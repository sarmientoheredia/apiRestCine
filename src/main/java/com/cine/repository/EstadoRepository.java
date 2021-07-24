package com.cine.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cine.model.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long>{

}
