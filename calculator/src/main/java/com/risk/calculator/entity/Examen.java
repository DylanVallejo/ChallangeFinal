package com.risk.calculator.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
//import javax.persistence.FetchType;
//import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;



@Entity
@Table(name="examen", uniqueConstraints = {@UniqueConstraint(columnNames= {"id"})})
public class Examen {
//	azucar, grasas oxigeno riesgo
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    

    @DecimalMax(value = "100")
    @DecimalMin(value = "0")
    private Long azucar;
    
    @DecimalMax(value = "100")
    @DecimalMin(value = "0")
    private Long grasas;
    
    @DecimalMax(value = "100")
    @DecimalMin(value = "0")
    private Long oxigeno;
    
    private String riesgo;
    
    
    
//    creando relacion one to many varios examenes un paciente 
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "paciente_id")
    @JsonProperty(access = Access.WRITE_ONLY)
    private Paciente paciente;
    
    
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getAzucar() {
		return azucar;
	}
	public void setAzucar(Long azucar) {
		this.azucar = azucar;
	}
	public Long getGrasas() {
		return grasas;
	}
	public void setGrasas(Long grasas) {
		this.grasas = grasas;
	}
	public Long getOxigeno() {
		return oxigeno;
	}
	public void setOxigeno(Long oxigeno) {
		this.oxigeno = oxigeno;
	}
	public String getRiesgo() {
		return riesgo;
	}
	public void setRiesgo(String riesgo) {
		this.riesgo = riesgo;
	}
	public Paciente getPaciente() {
		return paciente;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	
	
	
	public Examen(Long id, @DecimalMax("100") @DecimalMin("0") Long azucar,
			@DecimalMax("100") @DecimalMin("0") Long grasas, @DecimalMax("100") @DecimalMin("0") Long oxigeno,
			String riesgo, Paciente paciente) {
		super();
		this.id = id;
		this.azucar = azucar;
		this.grasas = grasas;
		this.oxigeno = oxigeno;
		this.riesgo = riesgo;
		this.paciente = paciente;
	}
	
	
	public Examen(Long id, @DecimalMax("100") @DecimalMin("0") Long azucar,
			@DecimalMax("100") @DecimalMin("0") Long grasas, @DecimalMax("100") @DecimalMin("0") Long oxigeno,
			String riesgo) {
		super();
		this.id = id;
		this.azucar = azucar;
		this.grasas = grasas;
		this.oxigeno = oxigeno;
		this.riesgo = riesgo;
	}
	public Examen() {
		super();
	}

}
