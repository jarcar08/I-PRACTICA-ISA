package com.example.demo.service;
import java.util.List;
import com.example.demo.entity.Empresa;

public interface EmpresaService {
	List<Empresa> listAllEmpresa();
	Empresa addCEmpresa(Empresa empresa);
    void deleteEmpresa(int id);
    Empresa getEmpresaById(int id);
    List<Empresa> buscarPorFiltro(String tipo, String valor);
}