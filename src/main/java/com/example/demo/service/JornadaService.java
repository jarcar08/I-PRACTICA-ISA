package com.example.demo.service;
import java.util.List;
import com.example.demo.entity.Jornada;

public interface JornadaService {
	List<Jornada> listAllJornada();
	Jornada addJornada(Jornada jornada);
    void deleteJornada(int id);
    Jornada getJornadaById(int id);
    List<Jornada> buscarPorFiltro(String tipo, String valor);
}