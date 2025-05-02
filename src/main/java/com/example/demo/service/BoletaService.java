package com.example.demo.service;
import java.util.List;
import com.example.demo.entity.Boleta;

public interface BoletaService {
	List<Boleta> listAllBoleta();
	Boleta addBoleta(Boleta boleta);
    void deleteBoleta(int id);
    Boleta getBoletaById(int id);
    List<Boleta> buscarPorFiltro(String tipo, String valor);
}