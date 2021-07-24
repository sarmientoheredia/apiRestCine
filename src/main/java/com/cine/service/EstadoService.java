package com.cine.service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cine.model.Estado;
import com.cine.repository.EstadoRepository;

@Service
public class EstadoService implements BaseService<Estado>{

	@Autowired
	private EstadoRepository estadoRepo;
	
	@Override
	public List<Estado> obtenerTodo() {
		return estadoRepo.findAll();
	}

	@Override
	public Optional<Estado> obtenerPorId(Long id) {
		Optional<Estado> estado=estadoRepo.findById(id);
		if(estado.isEmpty()) {
			return Optional.empty();
		}else {
			return estado;
		}
	}

	@Override
	public Estado guardar(Estado entity) {
		entity =estadoRepo.save(entity);
		return entity;
	}

	@Override
	public HashMap<String, String> eliminarPorId(Long id) {
		HashMap<String, String> respuesta=new HashMap<String,String>();
		estadoRepo.deleteById(id);
		respuesta.put("mensaje", "ELEMENTO ELIMINADO CORRECTAMENTE");
		return respuesta;
	}

}
