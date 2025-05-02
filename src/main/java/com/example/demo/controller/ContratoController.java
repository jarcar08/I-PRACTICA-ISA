package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.example.demo.entity.Contrato;
import com.example.demo.service.ContratoService;

@Controller
@RequestMapping("/contrato")
public class ContratoController {
	@Autowired
	@Qualifier("contratoservice")
	private ContratoService contratoService;

	// MOSTRAR CONTRATOS
	@GetMapping("/lista")
	@ResponseBody
	public List<Contrato> listAllContratos() {
		List<Contrato> contratos = contratoService.listAllContrato();
		if (contratos == null || contratos.isEmpty()) {
			System.out.println("No se encontraron contratos en la base de datos.");
		}
		return contratos;
	}

	// BUSCAR CONTRATOS SEGUN EL TIPO
	@GetMapping("/buscar")
	@ResponseBody
	public List<Contrato> buscarContrato(@RequestParam("tipo") String tipo, @RequestParam("valor") String valor) {
		if (tipo.equals("todos")) {
			return contratoService.listAllContrato();
		} else {
			return contratoService.buscarPorFiltro(tipo, valor);
		}
	}

	// GUARDAR CONTRATO
	@PostMapping("/guardar")
	@ResponseBody
	public String addContrato(@RequestBody Contrato contrato) {
		contratoService.addContrato(contrato);
		return "Contrato guardado correctamente";
	}

	// EDITAR CONTRATO
	@GetMapping("/editar/{id}")
	@ResponseBody
	public Contrato getContrato(@PathVariable("id") int id) {
		return contratoService.getContratoById(id);
	}

	// ELIMINAR CONTRATO
	@DeleteMapping("/eliminar/{id}")
	@ResponseBody
	public String deleteContrato(@PathVariable("id") int id) {
		contratoService.deleteContrato(id);
		return "Contrato eliminado correctamente";
	}
}