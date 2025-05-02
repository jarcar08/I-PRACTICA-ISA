package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.example.demo.entity.DetalleBoleta;
import com.example.demo.service.DetalleBoletaService;

@Controller
@RequestMapping("/detalleboleta")
public class DetalleBoletaController {
	@Autowired
	@Qualifier("contratoservice")
	private DetalleBoletaService detalleBoletaService;

	// MOSTRAR DETALLE BOLETAS
	@GetMapping("/lista")
	@ResponseBody
	public List<DetalleBoleta> listAllDetalleBoletas() {
		List<DetalleBoleta> detalleBoletas = detalleBoletaService.listAllDetalleBoleta();
		if (detalleBoletas == null || detalleBoletas.isEmpty()) {
			System.out.println("No se encontraron detalles boletas en la base de datos.");
		}
		return detalleBoletas;
	}

	// BUSCAR DETALLE BOLETAS SEGUN EL TIPO
	@GetMapping("/buscar")
	@ResponseBody
	public List<DetalleBoleta> buscarDetalleBoleta(@RequestParam("tipo") String tipo,
			@RequestParam("valor") String valor) {
		if (tipo.equals("todos")) {
			return detalleBoletaService.listAllDetalleBoleta();
		} else {
			return detalleBoletaService.buscarPorFiltro(tipo, valor);
		}
	}

	// GUARDAR DETALLE BOLETA
	@PostMapping("/guardar")
	@ResponseBody
	public String addDetalleBoleta(@RequestBody DetalleBoleta detalleBoleta) {
		detalleBoletaService.addDetalleBoleta(detalleBoleta);
		return "Detalle boleta guardado correctamente";
	}

	// EDITAR DETALLE BOLETA
	@GetMapping("/editar/{id}")
	@ResponseBody
	public DetalleBoleta getDetalleBoleta(@PathVariable("id") int id) {
		return detalleBoletaService.getDetalleBoletaById(id);
	}

	// ELIMINAR DETALLE BOLETA
	@DeleteMapping("/eliminar/{id}")
	@ResponseBody
	public String deleteDetalleBoleta(@PathVariable("id") int id) {
		detalleBoletaService.deleteDetalleBoleta(id);
		return "Detalle boleta eliminado correctamente";
	}
}