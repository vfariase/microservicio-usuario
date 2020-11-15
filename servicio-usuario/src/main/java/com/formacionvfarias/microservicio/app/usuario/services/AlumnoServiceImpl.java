package com.formacionvfarias.microservicio.app.usuario.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.formacionvfarias.microservicio.app.commons.services.CommonServiceImpl;
import com.formacionvfarias.microservicio.app.usuario.entity.Alumno;
import com.formacionvfarias.microservicio.app.usuario.repository.AlumnoRepository;


@Service
public class AlumnoServiceImpl extends CommonServiceImpl<Alumno, AlumnoRepository> implements AlumnoService {


	
	
}
