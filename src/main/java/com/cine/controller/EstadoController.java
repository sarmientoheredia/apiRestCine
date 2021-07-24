package com.cine.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cine.exception.ResourceNotFoundExecption;
import com.cine.model.Estado;
import com.cine.service.EstadoService;


@RestController
@RequestMapping(path = "api/v1/estado")
public class EstadoController {

	
	
	
	@Autowired
	private EstadoService estadoService;
	
	
	
	//OBTENER TODAS LAS PERSONAS
	@GetMapping("")
	public ResponseEntity<List<Estado>> listarEstados(){
		List<Estado> estados=new ArrayList<Estado>();
		estadoService.obtenerTodo().forEach(estados::add);
		
		if(estados.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
			
		//esto devuelve el listado en el cuerpo de la aplicacion 
		return new ResponseEntity<>(estados, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Estado> obtenerEstadoPorId(@PathVariable("id") Long id){
		Estado estado=estadoService
				.obtenerPorId(id).orElseThrow(()-> new ResourceNotFoundExecption("RECURSO CON EL ID "+ id+" NO ENCONTRADO"));
		return new ResponseEntity<>(estado,HttpStatus.OK);
		
	}
	
	@PostMapping("")
	public ResponseEntity<Estado> crearEstado(
			@RequestBody Estado estado){
		Estado nuevoEstado=estadoService.guardar(estado);
		
		return new ResponseEntity<>(nuevoEstado,HttpStatus.CREATED);
	}

	
	@PutMapping("/{id}")
	public ResponseEntity<Estado> actualizarEstado(
			@PathVariable("id") Long id,
			@RequestBody Estado estado){
		
		Estado estadoActualizar=estadoService.obtenerPorId(id)
				.orElseThrow(()-> new ResourceNotFoundExecption(
						"El estado con el id "+id+" no encotrado"));
		
		estadoActualizar.setDescestado(estado.getDescestado());
		
		return new ResponseEntity<>(estadoService.guardar(estadoActualizar),HttpStatus.OK);
	}
	
	
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminarestado(@PathVariable ("id") Long id){
		
		estadoService.obtenerPorId(id)
		.orElseThrow(()-> new ResourceNotFoundExecption("RESURSO CON EL ID: "+id+" NO ENCONTRADO"));
		
		return  ResponseEntity.status(HttpStatus.OK).body(estadoService.eliminarPorId(id));
	}


	
	
	

}
