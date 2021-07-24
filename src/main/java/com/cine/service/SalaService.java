package com.cine.service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cine.model.Sala;
import com.cine.repository.SalaRepository;

@Service
public class SalaService implements BaseService<Sala> {

	@Autowired
	private SalaRepository salaRepo;

	@Override
	public List<Sala> obtenerTodo() {
		// TODO Auto-generated method stub
		return salaRepo.findAll();
	}

	@Override
	public Optional<Sala> obtenerPorId(Long id) {
		// TODO Auto-generated method stub

		Optional<Sala> sala = salaRepo.findById(id);

		if (sala.isEmpty()) {
			return Optional.empty();
		} else {
			return sala;
		}
	}

	@Override
	public Sala guardar(Sala entity) {
		// TODO Auto-generated method stub
		return salaRepo.save(entity);
	}

	@Override
	public HashMap<String, String> eliminarPorId(Long id) {
		// TODO Auto-generated method stub
		HashMap<String, String> respuesta = new HashMap<String, String>();
		salaRepo.deleteById(id);
		respuesta.put("mensaje", "ELEMENTO ELIMINADO CORRECTAMENTE");
		return respuesta;
	}

}
