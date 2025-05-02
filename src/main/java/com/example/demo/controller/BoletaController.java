package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.example.demo.entity.Boleta;
import com.example.demo.service.BoletaService;

@Controller
@RequestMapping("/boleta")
public class BoletaController {
	@Autowired
	@Qualifier("boletaservice")
	private BoletaService boletaService;

	// MOSTRAR TODAS LAS BOLETAS
	@GetMapping("/lista")
	@ResponseBody
	public List<Boleta> listAllBoletas() {
		List<Boleta> boletas = boletaService.listAllBoleta();
		if (boletas == null || boletas.isEmpty()) {
			System.out.println("No se encontraron boletas en la base de datos.");
		}
		return boletas;
	}

	// BUSCAR BOLETA SEGÚN EL TIPO
	@GetMapping("/buscar")
	@ResponseBody
	public List<Boleta> buscarBoleta(@RequestParam("tipo") String tipo, @RequestParam("valor") String valor) {
		if (tipo.equals("todos")) {
			return boletaService.listAllBoleta();
		} else {
			return boletaService.buscarPorFiltro(tipo, valor);
		}
	}

	// GUARDAR BOLETA
	@PostMapping("/guardar")
	@ResponseBody
	public String addBoleta(@RequestBody Boleta boleta) {
		boletaService.addBoleta(boleta);
		return "Boleta guardada correctamente";
	}

	// EDITAR BOLETA
	@GetMapping("/editar/{id}")
	@ResponseBody
	public Boleta getBoleta(@PathVariable("id") int id) {
		return boletaService.getBoletaById(id);
	}

	// ELIMINAR BOLETA
	@DeleteMapping("/eliminar/{id}")
	@ResponseBody
	public String deleteBoleta(@PathVariable("id") int id) {
		boletaService.deleteBoleta(id);
		return "Boleta eliminada correctamente";
	}
}