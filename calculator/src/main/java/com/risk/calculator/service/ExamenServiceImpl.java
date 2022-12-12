package com.risk.calculator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.risk.calculator.entity.Examen;
//import com.risk.calculator.entity.Examen;
//import com.risk.calculator.entity.Paciente;
import com.risk.calculator.repository.ExamenRepository;
//import com.risk.calculator.repository.PacienteRepository;

//import com.risk.calculator.repository.PacienteRepository;
import java.util.List;
import java.util.Optional;

@Service
public class ExamenServiceImpl implements ExamenService{
		
	@Autowired
	private ExamenRepository examenRepository;
	
	@Override
	@Transactional(readOnly = true)
	public List<Examen> listar() {
		return (List<Examen>) examenRepository.findAll();
	}
	
	@Transactional(readOnly = true)
	@Override
	public Optional<Examen> porId(Long id) {
		 return examenRepository.findById(id);
	}
	
	@Override
	@Transactional
	public Examen guardar(Examen examen) {
		return examenRepository.save(examen);
	}
	
	
	@Override
	@Transactional
	public void eliminar(Long id) {
		examenRepository.deleteById(id);
		
	}

}
