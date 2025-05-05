package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.Empleado;
import com.example.demo.service.EmpleadoService;

@Controller
@RequestMapping("/empleado")
public class EmpleadoController {
	@Autowired
	@Qualifier("empleadoservice")
	private EmpleadoService empleadoService;

	/*// MOSTRAR EMPLEADOS
	@GetMapping("/lista")
	@ResponseBody
	public List<Empleado> listAllEmpleados() {
		List<Empleado> empleados = empleadoService.listAllEmpleado();
		if (empleados == null || empleados.isEmpty()) {
			System.out.println("No se encontraron empleados en la base de datos.");
		}
		return empleados;
	}*/
	
	//ListaEmpresas
		@GetMapping("/ListaEmpl")
		public ModelAndView listAllEmpleados() {
		    ModelAndView mav = new ModelAndView("ListaEmpl");  // Nombre de la vista Thymeleaf
		    mav.addObject("empleado", empleadoService.listAllEmpleado());  // Agregar la lista de empresas
		    return mav;
		}

	// BUSCAR EMPLEADOS SEGÚN EL TIPO
	@GetMapping("/buscar")
	@ResponseBody
	public List<Empleado> buscarEmpleado(@RequestParam("tipo") String tipo, @RequestParam("valor") String valor) {
		if (tipo.equals("todos")) {
			return empleadoService.listAllEmpleado();
		} else {
			return empleadoService.buscarPorFiltro(tipo, valor);
		}
	}

	// GUARDAR EMPLEADO
	@PostMapping("/guardar")
	@ResponseBody
	public String addEmpleado(@RequestBody Empleado empleado) {
		empleadoService.addEmpleado(empleado);
		return "Empleado guardado correctamente";
	}

	// EDITAR EMPLEADO
	@GetMapping("/editar/{id}")
	@ResponseBody
	public Empleado getEmpleado(@PathVariable("id") int id) {
		return empleadoService.getEmpleadoById(id);
	}

	// ELIMINAR EMPLEADO
	@DeleteMapping("/eliminar/{id}")
	@ResponseBody
	public String deleteEmpleado(@PathVariable("id") int id) {
		empleadoService.deleteEmpleado(id);
		return "Empleado eliminado correctamente";
	}
}