package com.cine.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cine.model.Empleado;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Long>{

	
	//ESTAS DOS ANOTACIONES PARA QUE SE ACTUALIZE AL TERMINAR LA TRANSACCION
	@Transactional
	@Modifying
	//DEFINICION DE UN PROYECTO ALMACENADO
	@Query(value="{call sp_RegistrarEmpleado(:nombre , :apellido)}",nativeQuery = true)
	void registrarEmpleado(@Param("nombre")String nombre,@Param("apellido")String apellido);
}
