package com.risk.calculator.controller;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.risk.calculator.entity.Examen;
import com.risk.calculator.entity.Paciente;
import com.risk.calculator.service.ExamenService;
import com.risk.calculator.service.PacienteService;

@RestController
@RequestMapping("/examen")
public class ExamenController {

	@Autowired
	private PacienteService pacienteService;
	
    @Autowired
    private ExamenService service;

    @GetMapping
    public List<Examen> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> detalle(@PathVariable Long id) {
        Optional<Examen> examenOptional = service.porId(id);
        if (examenOptional.isPresent()) {
            return ResponseEntity.ok(examenOptional.get());
        }
        return ResponseEntity.notFound().build();
    }

	@PostMapping
	public ResponseEntity<Examen> guardarExamen(@Validated @RequestBody Examen examen){
		Optional<Paciente> pacienteOptional = pacienteService.porId(examen.getPaciente().getId());
		
//definiendo el riesgo de enfermedad grave  
		if(examen.getAzucar() > 70 & examen.getGrasas() > 88.5 & examen.getOxigeno() < 60) {
			examen.setRiesgo("ALTO");
		}else if (
				examen.getAzucar() >= 50 & examen.getAzucar() <= 70 
				& examen.getGrasas() <= 88.5 & examen.getGrasas() >= 62.2 
				& examen.getOxigeno() >= 60 & examen.getOxigeno() <= 70
				) {
			examen.setRiesgo("MEDIO");
		}else if (
				examen.getAzucar() < 50
				& examen.getGrasas() < 62.2
				& examen.getOxigeno() > 70
				) {
			examen.setRiesgo("BAJO");
		}else {
			examen.setRiesgo("DATOS INCALCULABLES");
			}
		
		if(!pacienteOptional.isPresent()) {
			return ResponseEntity.unprocessableEntity().build();
		}
		examen.setPaciente(pacienteOptional.get());
		Examen examenGuardado = service.guardar(examen);
		return ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(examenGuardado));
	}
	
//operaciones put y delete no son necesarias ya que los examenes no deben ser eliminados ni modificados 
	
    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@RequestBody Examen examen, @PathVariable Long id) {
        Optional<Examen> o = service.porId(id);
        if (o.isPresent()) {
        	Examen examenDb = o.get();
        	examenDb.setId(examen.getId());
        	examenDb.setAzucar(examen.getAzucar());
        	examenDb.setGrasas(examen.getAzucar());
        	examenDb.setOxigeno(examen.getOxigeno());
        	examenDb.setRiesgo(examen.getRiesgo());
            return ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(examenDb));
        }
        return ResponseEntity.notFound().build();
    }
    
    
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        Optional<Examen> o = service.porId(id);
        if (o.isPresent()) {
            service.eliminar(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}

