package com.cine.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cine.converdto.DtoUtil;
import com.cine.exception.ResourceNotFoundExecption;
import com.cine.model.Sala;
import com.cine.model.dto.DtoEntity;
import com.cine.model.dto.SalaDto;
import com.cine.service.SalaService;

@RestController
@RequestMapping(path="api/v1/sala")
public class SalaController {

	@Autowired
	private SalaService salaService;
	
	
	@GetMapping("/full")
	public ResponseEntity<List<Sala>> obtenerSalas(){
		List<Sala> salas=new ArrayList<Sala>();
		salaService.obtenerTodo()
		.forEach(salas::add);
		
		if(salas.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(salas,HttpStatus.OK);
	}
	
	
	
	@GetMapping("/dto")
	public ResponseEntity<List<DtoEntity>> obtenerSalasDto(){
		List<DtoEntity> salas=new ArrayList<DtoEntity>();
		
		salas=salaService.obtenerTodo().stream()
				.map(x -> new DtoUtil().convertirADto(x,new SalaDto()))
						.collect(Collectors.toList());
		
		if(salas.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(salas,HttpStatus.OK);
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Sala> obtenerSalaPorId(
			@PathVariable("id") Long id){
		
		Sala sala= salaService.obtenerPorId(id)
				.orElseThrow(()-> new ResourceNotFoundExecption("RECURSO CON EL ID "+id+" NO ENCONTRADO"));
		
		return new ResponseEntity<>(sala, HttpStatus.OK);
	}
	
	
}
