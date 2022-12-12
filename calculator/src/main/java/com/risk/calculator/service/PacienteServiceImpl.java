package com.risk.calculator.service;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//import com.risk.calculator.entity.Examen;
import com.risk.calculator.entity.Paciente;
//import com.risk.calculator.repository.ExamenRepository;
import com.risk.calculator.repository.PacienteRepository;
import java.util.List;
import java.util.Optional;

@Service
public class PacienteServiceImpl implements PacienteService{

	
//    @Autowired
//    private ExamenRepository examenRepository;
	
    @Autowired
    private PacienteRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<Paciente> listar() {
        return (List<Paciente>) repository.findAll();
    }
//    @Override
//    @Transactional(readOnly = true)
//    public List<Paciente> listar(Pageable pageable) {
//        return (List<Paciente>) repository.findAll();
//    }
    

    @Transactional(readOnly = true)
    @Override
    public Optional<Paciente> porId(Long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public Paciente guardar(Paciente paciente) {
        return repository.save(paciente);
    }

    @Override
    @Transactional
    public void eliminar(Long id) {
        repository.deleteById(id);
    }

//    @Override
//    @Transactional
//	public Examen guardarExamen(Examen examen) {
//		return repository.save(examen);
//	}


}
