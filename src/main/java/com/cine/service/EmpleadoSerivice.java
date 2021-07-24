package com.cine.service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cine.model.Empleado;
import com.cine.repository.EmpleadoRepository;

@Service
public class EmpleadoSerivice implements BaseService<Empleado> {
	
	@Autowired
	private EmpleadoRepository empleadoRepo;
	
	
	public HashMap<String ,String> registrarEmpleado(Empleado empleado){
		empleadoRepo.registrarEmpleado(empleado.getNombre(), empleado.getApellido());
		HashMap<String,String > respuesta=new HashMap<String,String>();
		respuesta.put("mensaje","EMPLEADO CREADO CORRECTAMENTE");
		return respuesta;
	}


	@Override
	public List<Empleado> obtenerTodo() {
		// TODO Auto-generated method stub
		return empleadoRepo.findAll();
	}


	@Override
	public Optional<Empleado> obtenerPorId(Long id) {
		Optional<Empleado> empleado=empleadoRepo.findById(id);
		if(empleado.isEmpty()) {
			return Optional.empty();
		}
		return empleado;
	}


	@Override
	public Empleado guardar(Empleado entity) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public HashMap<String, String> eliminarPorId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
