package com.cine.service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cine.model.Cliente;
import com.cine.repository.ClienteRepository;

@Service
public class ClienteService implements BaseService<Cliente>{

	
	@Autowired
	private ClienteRepository clienteRepo;
	
	public Optional<Cliente> buscarClientePorDni(String dniCliente){
		Optional<Cliente> cliente=clienteRepo.buscarClientePorDniNativeQuery(dniCliente);
		if(cliente.isEmpty()) {
			return Optional.empty();
		}else {
			return cliente;
		}
	}
	
	public Page<Cliente> buscarClientePorNombre(String nombreCliente,Pageable pageable ){
		
		return clienteRepo.buscarClientePorNombreNativeQuery(nombreCliente, pageable);
		
	}

	@Override
	public List<Cliente> obtenerTodo() {
		// TODO Auto-generated method stub
		return clienteRepo.findAll();
	}

	@Override
	public Optional<Cliente> obtenerPorId(Long id) {
		Optional<Cliente> cliente=clienteRepo.findById(id);
		if(cliente.isEmpty()) {
			return Optional.empty();
		}else {
			return cliente;
		}
		
	}
		
	

	@Override
	public Cliente guardar(Cliente entity) {
		entity =clienteRepo.save(entity);
		return entity;
	}

	
	
	@Override
	public HashMap<String, String> eliminarPorId(Long id) {
		HashMap<String, String> respuesta=new HashMap<String,String>();
		clienteRepo.deleteById(id);
		respuesta.put("mensaje", "CLIENTE ELIMINADO CORRECTAMENTE");
		return respuesta;
	}
}
