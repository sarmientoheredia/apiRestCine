package com.cine.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cine.exception.ResourceNotFoundExecption;
import com.cine.model.Empleado;
import com.cine.service.EmpleadoSerivice;

@RestController
@RequestMapping(path = "api/v1/empleado")
public class EmpleadoController {
	
	@Autowired
	private EmpleadoSerivice empleadoService;
	
	//METODO PARA ABOTENER EL LISTADO DE TODOS LOS EMPLEADOS REGISTRADOS
	@GetMapping("")
	public ResponseEntity<List<Empleado>> listarEmpleados(){
		List<Empleado> empleados=new ArrayList<>();
		empleados=empleadoService.obtenerTodo();
		if(empleados.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(empleados,HttpStatus.OK);
	}
	
	//METODO PARA OBTENER UN EMPLEADO POR EL ID
	@GetMapping("/{id}")
	public ResponseEntity<Empleado> obtenerEmpleadoPorId(@PathVariable("id") Long id){
		Empleado empleado=empleadoService.obtenerPorId(id).orElseThrow(()-> new ResourceNotFoundExecption("EMPLEADO CON EL ID: "+id+"NO ENCONTRADO"));
		
		return new ResponseEntity<>(empleado,HttpStatus.OK);
	}
	
	
	
	//METODO PARA REGISTRAR UN EMPLEADO USANDO UN PROCEDIMIENTO ALMACENADO
	@PostMapping("")
	public ResponseEntity<?> registrarEmpleado(
			@RequestBody Empleado empleado){
		return new ResponseEntity<>(empleadoService.registrarEmpleado(new Empleado(empleado.getNombre(),empleado.getApellido()))
				,HttpStatus.CREATED);
	}

}
