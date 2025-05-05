package com.example.demo.controller;

import java.sql.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.Contrato;
import com.example.demo.service.ContratoService;

@Controller
@RequestMapping("/contrato")
public class ContratoController {
	@Autowired
	@Qualifier("contratoservice")
	private ContratoService contratoService;

	// MOSTRAR CONTRATOS
	@GetMapping("/ListaContratos")
	public ModelAndView listAllContratos() {
		ModelAndView mav = new ModelAndView("ListaContratos"); // Nombre de la vista Thymeleaf
		mav.addObject("contratos", contratoService.listAllContratos());
		return mav;
	}

	// GUARDAR O ACTUALIZAR CONTRATO
	@PostMapping("/guardar")
	// @ResponseBody
	public String saveOrUpdateContrato(@RequestParam("conId") int conId, @RequestParam("conEmpId") int conEmpId,
			@RequestParam("conModContId") int conModContId, @RequestParam("conAreaId") int conAreaId,
			@RequestParam("conJornId") int conJornId, @RequestParam("conFechaInicio") String conFechaInicio,
			@RequestParam("conFechaFin") String conFechaFin, @RequestParam("conDiasTrabajo") int conDiasTrabajo,
			@RequestParam("conEstado") Byte conEstado) {
		// Convertir las fechas de String a Date
		Date fechaInicio = java.sql.Date.valueOf(conFechaInicio);
		Date fechaFin = java.sql.Date.valueOf(conFechaFin);

		// Crear un nuevo contrato o actualizar el existente
		Contrato contrato;
		if (conId > 0) {
			// Si el ID es mayor a cero, actualizamos el contrato
			contrato = contratoService.getContratoById(conId);
			contrato.setConEmpId(conEmpId);
			contrato.setConModContId(conModContId);
			contrato.setConAreaId(conAreaId);
			contrato.setConJornId(conJornId);
			contrato.setConFechaInicio(fechaInicio);
			contrato.setConFechaFin(fechaFin);
			contrato.setConDiasTrabajo(conDiasTrabajo);
			contrato.setConEstado(conEstado);
		} else {
			// Si no existe un contrato, creamos uno nuevo
			contrato = new Contrato(conEmpId, conModContId, conAreaId, conJornId, conDiasTrabajo, fechaInicio, fechaFin, conDiasTrabajo,
					conEstado);
		}
		contratoService.addContrato(contrato); // Guardamos el contrato (ya sea nuevo o actualizado)
		return "redirect:/contrato/ListaContratos";
	}

	// EDITAR CONTRATO
	@GetMapping("/editar/{id}")
	@ResponseBody
	public Contrato getContrato(@PathVariable("id") int id) {
		return contratoService.getContratoById(id);
	}

	// ELIMINAR CONTRATO
	// @DeleteMapping("/eliminar/{id}")
	// @ResponseBody
	@PostMapping("/eliminar/{id}")
	public String deleteContrato(@PathVariable("id") int id) {
		contratoService.deleteContrato(id);
		return "redirect:/contrato/ListaContratos";
	}
}
