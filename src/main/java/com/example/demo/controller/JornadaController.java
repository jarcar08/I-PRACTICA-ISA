package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.example.demo.entity.Jornada;
import com.example.demo.service.JornadaService;

@Controller
@RequestMapping("/jornada")
public class JornadaController {
	@Autowired
	@Qualifier("jornadaservice")
	private JornadaService jornadaService;

	// MOSTRAR TODAS LAS JORNADAS
	@GetMapping("/lista")
	@ResponseBody
	public List<Jornada> listAllJornadas() {
		List<Jornada> jornadas = jornadaService.listAllJornada();
		if (jornadas == null || jornadas.isEmpty()) {
			System.out.println("No se encontraron jornadas en la base de datos.");
		}
		return jornadas;
	}

	// BUSCAR JORNADAS SEGUN EL TIPO
	@GetMapping("/buscar")
	@ResponseBody
	public List<Jornada> buscarJornada(@RequestParam("tipo") String tipo, @RequestParam("valor") String valor) {
		if (tipo.equals("todos")) {
			return jornadaService.listAllJornada();
		} else {
			return jornadaService.buscarPorFiltro(tipo, valor);
		}
	}

	// GUARDAR JORNADA
	@PostMapping("/guardar")
	@ResponseBody
	public String addJornada(@RequestBody Jornada jornada) {
		jornadaService.addJornada(jornada);
		return "Jornada guardada correctamente";
	}

	// EDITAR JORNADA
	@GetMapping("/editar/{id}")
	@ResponseBody
	public Jornada getJornada(@PathVariable("id") int id) {
		return jornadaService.getJornadaById(id);
	}

	// ELIMINAR JORNADA
	@DeleteMapping("/eliminar/{id}")
	@ResponseBody
	public String deleteJornada(@PathVariable("id") int id) {
		jornadaService.deleteJornada(id);
		return "Jornada eliminada correctamente";
	}
}