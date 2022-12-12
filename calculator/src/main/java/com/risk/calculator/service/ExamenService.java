package com.risk.calculator.service;

import java.util.List;
import java.util.Optional;

import com.risk.calculator.entity.Examen;


public interface ExamenService {
    List<Examen> listar();
    Optional<Examen> porId(Long id);
    Examen guardar(Examen examen);
    void eliminar(Long id);
}
