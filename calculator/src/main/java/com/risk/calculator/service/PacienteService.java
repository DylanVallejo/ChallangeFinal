package com.risk.calculator.service;

import java.util.List;
import java.util.Optional;

//import org.springframework.data.domain.Pageable;

//import com.risk.calculator.entity.Examen;
import com.risk.calculator.entity.Paciente;

public interface PacienteService {
    List<Paciente> listar();
    Optional<Paciente> porId(Long id);
    Paciente guardar(Paciente paciente);
    void eliminar(Long id);
//    Examen guardarExamen(Examen examen);
    
//    agreagar metodo para examenes
}
