package com.formacionvfarias.microservicio.app.usuario.controllers;

import java.util.Optional;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.formacionvfarias.microservicio.app.commons.controllers.CommonController;
import com.formacionvfarias.microservicio.app.usuario.entity.Alumno;
import com.formacionvfarias.microservicio.app.usuario.services.AlumnoService;

@RestController
public class UsuarioController extends CommonController<Alumno, AlumnoService> {

        
    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@RequestBody Alumno alumno, @PathVariable Long id){
    	
    	Optional<Alumno> o = service.findById(id);
    	
    	if(!o.isPresent()) {
    		return ResponseEntity.notFound().build();
    	}
    	
    	Alumno alummoDb = o.get();
    	alummoDb.setApellido(alumno.getApellido());
    	alummoDb.setNombre(alumno.getApellido());
    	alummoDb.setCreateAt(alumno.getCreateAt());
    	
    	return ResponseEntity.status(HttpStatus.CREATED).body(service.save(o.get()));
    }
    

}
