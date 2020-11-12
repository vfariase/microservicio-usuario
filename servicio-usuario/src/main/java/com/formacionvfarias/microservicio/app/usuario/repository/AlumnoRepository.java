package com.formacionvfarias.microservicio.app.usuario.repository;

import org.springframework.data.repository.CrudRepository;

import com.formacionvfarias.microservicio.app.usuario.entity.Alumno;

public interface AlumnoRepository extends CrudRepository<Alumno, Long> {
 
}
