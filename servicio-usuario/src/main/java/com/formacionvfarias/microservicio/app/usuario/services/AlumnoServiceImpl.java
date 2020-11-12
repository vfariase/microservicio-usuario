package com.formacionvfarias.microservicio.app.usuario.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.formacionvfarias.microservicio.app.usuario.entity.Alumno;
import com.formacionvfarias.microservicio.app.usuario.repository.AlumnoRepository;


@Service
public class AlumnoServiceImpl implements AlumnoService {

	@Autowired
	private AlumnoRepository repository;
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<Alumno> findAll() {
		return repository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Alumno> findById(Long id) {
        return repository.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Alumno save(Alumno alumno) {
		return repository.save(alumno);
	}

	@Override
	@Transactional(readOnly = true)
	public void deleteById(Long id) {
       repository.deleteById(id);
	}

}
