package com.cine.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cine.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{

	//metodo para 
	@Query (value="SELECT c FROM Cliente c WHERE c.dnicliente =:dnicliente")
	Optional<Cliente> buscarClientePorDniJpql(@Param("dnicliente") String dnicliente);
	
	
	@Query(value="SELECT *FROM cliente WHERE cliente.dnicliente= :dnicliente", nativeQuery = true)
	Optional<Cliente> buscarClientePorDniNativeQuery(@Param("dnicliente") String dnicliente);

	@Query (value = "SELECT *FROM cliente WHERE cliente.nomcliente LIKE %:nomcliente%",nativeQuery = true
			,countQuery = "SELECT count(*) FROM cliente WHERE cliente.nomcliente LIKE %:nomcliente%")
	Page<Cliente> buscarClientePorNombreNativeQuery(
			@Param("nomcliente") String nomcliente, Pageable pageable);
	
	
	

}
