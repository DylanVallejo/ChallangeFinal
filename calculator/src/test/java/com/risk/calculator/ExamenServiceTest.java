package com.risk.calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import com.risk.calculator.entity.Examen;
import com.risk.calculator.repository.ExamenRepository;
import com.risk.calculator.service.ExamenServiceImpl;



@ExtendWith(MockitoExtension.class)
public class ExamenServiceTest {
	
	
	
	@Mock
	private ExamenRepository examenRepository;
	
	@InjectMocks
	private ExamenServiceImpl examenServiceImpl; 
	
//	creando metodo con el que haremos pruebas 
	
	@Test
	void deberiaEncontrarTodos() {
		Examen examen = new Examen(
				 1L,
				60L,
				60L,
				60L,
				"ALTO"
			);
		
		List<Examen> examenes = new ArrayList<Examen>();
		examenes.add(examen);
		Iterable<Examen> examnesDb = examenes;
		Mockito.when(examenRepository.findAll()).thenReturn(examnesDb);
		assertNotNull(examenServiceImpl.listar());
		assertEquals(1, examenServiceImpl.listar().size());
	}

}
