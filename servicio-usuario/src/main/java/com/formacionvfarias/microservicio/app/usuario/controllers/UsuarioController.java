package com.formacionvfarias.microservicio.app.usuario.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.formacionvfarias.microservicio.app.usuario.entity.Alumno;
import com.formacionvfarias.microservicio.app.usuario.services.AlumnoService;

@RestController
public class UsuarioController {

     @Autowired
     private AlumnoService alumnoService;
	
    @GetMapping
	public ResponseEntity<?> listar(){
		return ResponseEntity.ok().body(alumnoService.findAll());
	}

    @GetMapping("/{id}")
	public ResponseEntity<?> ver(@PathVariable Long id){
    	Optional<Alumno> o = alumnoService.findById(id);
    	
    	if(!o.isPresent()) {
    		return ResponseEntity.notFound().build();
    	}
    	
		return ResponseEntity.ok(o.get());
	}
    
    @PostMapping
    public ResponseEntity<?> crear(@RequestBody Alumno alumno) {
    	
    	Alumno alumnoDb = alumnoService.save(alumno); 
    	return ResponseEntity.status(HttpStatus.CREATED).body(alumnoDb);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@RequestBody Alumno alumno, @PathVariable Long id){
    	
    	Optional<Alumno> o = alumnoService.findById(id);
    	
    	if(!o.isPresent()) {
    		return ResponseEntity.notFound().build();
    	}
    	
    	Alumno alummoDb = o.get();
    	alummoDb.setApellido(alumno.getApellido());
    	alummoDb.setNombre(alumno.getApellido());
    	alummoDb.setCreateAt(alumno.getCreateAt());
    	
    	return ResponseEntity.status(HttpStatus.CREATED).body(alumnoService.save(o.get()));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
    	alumnoService.deleteById(id);
    	return ResponseEntity.noContent().build();
    }
}
