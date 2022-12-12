package com.risk.calculator.entity;


import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

//import lombok.Data;

@Entity
@Table(name="paciente")
public class Paciente {
	
	// id , nombre, email 

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nombre;

    @Column(unique = true)
    private String email;
    
    
    //creando relacion bidireccional 
    
    //si elimino un paciente se eliminara sus examenes 
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "paciente", cascade = CascadeType.ALL )
    private Collection<Examen> examenes = new HashSet<>();
//    private Set<Examen> examenes = new HashSet<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Collection<Examen> getExamenes() {
		return examenes;
	}
//	public Set<Examen> getExamenes() {
//		return examenes;
//	}

	public void setExamenes(Set<Examen> examenes) {
		this.examenes = examenes;
		for(Examen examen : examenes) {
			examen.setPaciente(this);
		}
	}

	public Paciente(Long id, String nombre, String email, Collection<Examen> examenes) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.email = email;
		this.examenes = examenes;
	}
	
	public Paciente(Long id, String nombre, String email) {
//		super();
		this.id = id;
		this.nombre = nombre;
		this.email = email;
	}
	
	public Paciente() {
		super();
	}	
		
	
	


}
