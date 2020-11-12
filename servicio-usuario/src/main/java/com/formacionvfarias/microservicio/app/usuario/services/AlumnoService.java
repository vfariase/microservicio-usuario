package com.formacionvfarias.microservicio.app.usuario.services;

import java.util.Optional;

import com.formacionvfarias.microservicio.app.usuario.entity.Alumno;

public interface AlumnoService {
	
	public Iterable<Alumno> findAll();
	public Optional<Alumno> findById(Long id);
	public Alumno save(Alumno alumno);
	public void deleteById(Long id);

}
