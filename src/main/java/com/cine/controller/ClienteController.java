package com.cine.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cine.exception.ResourceNotFoundExecption;
import com.cine.model.Cliente;
import com.cine.service.ClienteService;

@RestController
@RequestMapping("api/v1/cliente")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;
	
	@GetMapping("/dni/{dni}")
	public ResponseEntity<Cliente> buscarClientePorDni(
			@PathVariable("dni") String dni){
		Cliente cliente= clienteService.buscarClientePorDni(dni)
				.orElseThrow(()-> new ResourceNotFoundExecption("EL CLIENTE CON EL DNI "+dni+" NO EXISTE"));
		
	
		return new ResponseEntity<>(cliente,HttpStatus.OK);
	
	}
	
	@GetMapping("/pageable")
	public ResponseEntity<?> buscarClientePorNombre(
			@RequestParam String nombre,Pageable pageable
			){
		Page<Cliente> clientes= clienteService.buscarClientePorNombre(nombre, pageable);
		if(clientes.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(clientes, HttpStatus.OK);
		
	}
	
	
	@GetMapping("")
	public ResponseEntity<List<Cliente>> listarClientes(){
		List<Cliente> clientes=new ArrayList<Cliente>();
		clienteService.obtenerTodo().forEach(clientes::add);
		
		if(clientes.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
			
		//esto devuelve el listado en el cuerpo de la aplicacion 
		return new ResponseEntity<>(clientes, HttpStatus.OK);
	}
	
	
	
}
