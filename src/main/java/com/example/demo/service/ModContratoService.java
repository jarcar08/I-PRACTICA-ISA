package com.example.demo.service;
import java.util.List;
import com.example.demo.entity.ModContrato;

public interface ModContratoService {
	List<ModContrato> listAllModContrato();
	ModContrato addModContrato(ModContrato modContrato);
    void deleteModContrato(int id);
    ModContrato getModContratoById(int id);
    List<ModContrato> buscarPorFiltro(String tipo, String valor);
}