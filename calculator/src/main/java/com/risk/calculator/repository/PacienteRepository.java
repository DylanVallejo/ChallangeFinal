package com.risk.calculator.repository;


import org.springframework.data.repository.CrudRepository;

//import com.risk.calculator.entity.Examen;
import com.risk.calculator.entity.Paciente;


public interface PacienteRepository extends CrudRepository<Paciente, Long> {

}
