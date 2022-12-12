package com.risk.calculator.controller;

//import com.risk.calculator.entity.Examen;
import com.risk.calculator.entity.Paciente;
//import com.risk.calculator.repository.PacienteRepository;
import com.risk.calculator.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

//import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/paciente")
public class PacienteController {

    @Autowired
    private PacienteService service;

    @GetMapping
    public List<Paciente> listar() {
//        return service.listar(pageable);
        return  service.listar();
    }
    
//obteniendo un paciente por id 
    @GetMapping("/{id}")
    public ResponseEntity<?> detalle(@PathVariable Long id) {
        Optional<Paciente> pacienteOptional = service.porId(id);
        if (pacienteOptional.isPresent()) {
            return ResponseEntity.ok(pacienteOptional.get());
        }
        return ResponseEntity.notFound().build();
    }

//creando paciente
	@PostMapping
	public ResponseEntity<?> crear(@RequestBody Paciente paciente) {
			return ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(paciente));
	}
	
//modificando datos de un paciente
    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@RequestBody Paciente paciente, @PathVariable Long id) {
        Optional<Paciente> o = service.porId(id);
        if (o.isPresent()) {
            Paciente pacienteDb = o.get();
            pacienteDb.setNombre(paciente.getNombre());
            pacienteDb.setEmail(paciente.getEmail());
            return ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(pacienteDb));
        }
        return ResponseEntity.notFound().build();
    }
    
//borrando un paciente
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        Optional<Paciente> o = service.porId(id);
        if (o.isPresent()) {
            service.eliminar(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
    
    
    
    
    //anadiendo paginacion al api
//    @GetMapping
//    public ResponseEntity<List<Paciente>> listar(Pageable pageable) {
////        return service.listar(pageable);
//        return  ResponseEntity.ok(service.listar(pageable));
//    }

}
