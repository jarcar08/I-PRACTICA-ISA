package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.example.demo.entity.ModContrato;
import com.example.demo.service.ModContratoService;

@Controller
@RequestMapping("/modcontrato")
public class ModContratoController {

	@Autowired
	@Qualifier("modcontratoservice")
	private ModContratoService modContratoService;

	// MOSTRAR TODOS LOS MODCONTRATOS
	@GetMapping("/lista")
	@ResponseBody
	public List<ModContrato> listAllModContratos() {
		List<ModContrato> modContratos = modContratoService.listAllModContrato();
		if (modContratos == null || modContratos.isEmpty()) {
			System.out.println("No se encontraron modos de contrato en la base de datos.");
		}
		return modContratos;
	}

	// BUSCAR MODCONTRATO SEGUN EL TIPO
	@GetMapping("/buscar")
	@ResponseBody
	public List<ModContrato> buscarModContrato(@RequestParam("tipo") String tipo, @RequestParam("valor") String valor) {
		if (tipo.equals("todos")) {
			return modContratoService.listAllModContrato();
		} else {
			return modContratoService.buscarPorFiltro(tipo, valor);
		}
	}

	// GUARDAR MODCONTRATO
	@PostMapping("/guardar")
	@ResponseBody
	public String addModContrato(@RequestBody ModContrato modContrato) {
		modContratoService.addModContrato(modContrato);
		return "Modo de contrato guardado correctamente";
	}

	// EDITAR MODCONTRATO
	@GetMapping("/editar/{id}")
	@ResponseBody
	public ModContrato getModContrato(@PathVariable("id") int id) {
		return modContratoService.getModContratoById(id);
	}

	// ELIMINAR MODCONTRATO
	@DeleteMapping("/eliminar/{id}")
	@ResponseBody
	public String deleteModContrato(@PathVariable("id") int id) {
		modContratoService.deleteModContrato(id);
		return "Modo de contrato eliminado correctamente";
	}
}