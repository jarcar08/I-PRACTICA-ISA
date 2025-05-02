package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.example.demo.entity.Area;
import com.example.demo.service.AreaService;

@Controller
@RequestMapping("/area")
public class AreaController {
	@Autowired
	@Qualifier("areaservice")
	private AreaService areaService;

	// MOSTRAR AREAS
	@GetMapping("/lista")
	@ResponseBody
	public List<Area> listAllArea() {
		List<Area> areas = areaService.listAllArea();
		if (areas == null || areas.isEmpty()) {
			System.out.println("No se encontraron areas en la base de datos.");
		}
		return areas;
	}

	// BUSCAR AREAS SEGUN EL TIPO
	@GetMapping("/buscar")
	@ResponseBody
	public List<Area> buscarArea(@RequestParam("tipo") String tipo, @RequestParam("valor") String valor) {
		if (tipo.equals("todos")) {
			return areaService.listAllArea();
		} else {
			return areaService.buscarPorFiltro(tipo, valor);
		}
	}

	// GUARDAR AREA
	@PostMapping("/guardar")
	@ResponseBody
	public String addArea(@RequestBody Area area) {
		areaService.addContrato(area);
		return "Area guardada correctamente";
	}

	// EDITAR AREA
	@GetMapping("/editar/{id}")
	@ResponseBody
	public Area getArea(@PathVariable("id") int id) {
		return areaService.getAreaById(id);
	}

	// ELIMINAR AREAS
	@DeleteMapping("/eliminar/{id}")
	@ResponseBody
	public String deleteArea(@PathVariable("id") int id) {
		areaService.deleteArea(id);
		return "Area eliminado correctamente";
	}
}