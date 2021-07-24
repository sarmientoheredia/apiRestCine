package com.cine.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cine.model.Sala;

@Repository
public interface SalaRepository extends JpaRepository<Sala, Long> {

	
}
