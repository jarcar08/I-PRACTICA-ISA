package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.Area;
import com.example.demo.service.AreaService;

@Controller
@RequestMapping("/area")
public class AreaController {

	@Autowired
	@Qualifier("areaservice")
	private AreaService areaService;

	@GetMapping("/ListaAre")
	public ModelAndView listAllAreas(Model model) {
		ModelAndView mav = new ModelAndView("ListaAre");
		model.addAttribute("area", areaService.listAllArea());
		mav.addObject("usuario", areaService.listAllArea());
		return mav;
	}

	// Buscar áreas según tipo
	@GetMapping("/buscar")
	@ResponseBody
	public List<Area> buscarArea(@RequestParam("tipo") String tipo, @RequestParam("valor") String valor) {
		if (tipo.equals("todos")) {
			return areaService.listAllArea();
		} else {
			return areaService.buscarPorFiltro(tipo, valor);
		}
	}

	// Crear o editar área
	@PostMapping("/guardar")
	public String addArea(@RequestParam(value = "areId", required = false) String areId,
			@RequestParam("areNombre") String nombre, @RequestParam("areSalario") double salario) {

		Area area;
		if (areId != null && !areId.trim().isEmpty()) {
			// Editar área existente
			int id = Integer.parseInt(areId);
			area = areaService.getAreaById(id);
			if (area == null) {
				return "redirect:/area/ListaAre?error=notfound";
			}
		} else {
			// Nueva área
			area = new Area();
		}

		area.setAreNombre(nombre);
		area.setAreSalario(salario);
		areaService.addContrato(area);

		return "redirect:/area/ListaAre";
	}

	// Obtener área por ID para editar
	@GetMapping("/editar/{id}")
	@ResponseBody
	public Area getArea(@PathVariable("id") int id) {
		return areaService.getAreaById(id);
	}

	// Eliminar área
	@DeleteMapping("/eliminar/{id}")
	@ResponseBody
	public String deleteArea(@PathVariable("id") int id) {
		areaService.deleteArea(id);
		return "Área eliminada correctamente";
	}
}
