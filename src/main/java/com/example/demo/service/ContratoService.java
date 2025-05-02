package com.example.demo.service;
import java.util.List;
import com.example.demo.entity.Contrato;

public interface ContratoService {
	List<Contrato> listAllContrato();
	Contrato addContrato(Contrato contrato);
    void deleteContrato(int id);
    Contrato getContratoById(int id);
    List<Contrato> buscarPorFiltro(String tipo, String valor);
}