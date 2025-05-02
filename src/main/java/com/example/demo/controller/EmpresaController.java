package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.example.demo.entity.Empresa;
import com.example.demo.service.EmpresaService;

@Controller
@RequestMapping("/empresa")
public class EmpresaController {
	@Autowired
	@Qualifier("empresaservice")
	private EmpresaService empresaService;

	// MOSTRAR EMPRESAS
	@GetMapping("/lista")
	@ResponseBody
	public List<Empresa> listAllEmpresas() {
		List<Empresa> empresas = empresaService.listAllEmpresa();
		if (empresas == null || empresas.isEmpty()) {
			System.out.println("No se encontraron empresas en la base de datos.");
		}
		return empresas;
	}

	// BUSCAR EMPRESAS SEGUN EL TIPO
	@GetMapping("/buscar")
	@ResponseBody
	public List<Empresa> buscarEmpresa(@RequestParam("tipo") String tipo, @RequestParam("valor") String valor) {
		if (tipo.equals("todos")) {
			return empresaService.listAllEmpresa();
		} else {
			return empresaService.buscarPorFiltro(tipo, valor);
		}
	}

	// GUARDAR EMPRESA
	@PostMapping("/guardar")
	@ResponseBody
	public String addEmpresa(@RequestBody Empresa empresa) {
		empresaService.addCEmpresa(empresa);
		return "Empresa guardada correctamente";
	}

	// EDITAR EMPRESA
	@GetMapping("/editar/{id}")
	@ResponseBody
	public Empresa getEmpresa(@PathVariable("id") int id) {
		return empresaService.getEmpresaById(id);
	}

	// ELIMINAR EMPRESA
	@DeleteMapping("/eliminar/{id}")
	@ResponseBody
	public String deleteEmpresa(@PathVariable("id") int id) {
		empresaService.deleteEmpresa(id);
		return "Empresa eliminada correctamente";
	}
}