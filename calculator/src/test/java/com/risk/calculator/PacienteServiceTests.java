package com.risk.calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

//import org.assertj.core.util.Arrays;
//import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
//import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.boot.test.context.SpringBootTest;

import com.risk.calculator.entity.Paciente;
import com.risk.calculator.repository.PacienteRepository;
//import com.risk.calculator.service.PacienteService;
import com.risk.calculator.service.PacienteServiceImpl;

@ExtendWith(MockitoExtension.class)
class PacienteServiceTests {

	
	@Mock
	private PacienteRepository pacienteRepository;
	
	@InjectMocks
	private PacienteServiceImpl pacienteServiceImpl; 
	
//	creando metodo con el que haremos pruebas 
	
	@Test
	void deberiaEncontrarTodos() {
		Paciente paciente = new Paciente(
				 1L,
				"dylan",
				"dylan@gmail.com"
				);
		
		List<Paciente> pacientes = new ArrayList<Paciente>();
		pacientes.add(paciente);
		Iterable<Paciente> pacientesDb = pacientes;
		Mockito.when(pacienteRepository.findAll()).thenReturn(pacientesDb);
		assertNotNull(pacienteServiceImpl.listar());
		assertEquals(1, pacienteServiceImpl.listar().size());
	}
	
	
}
