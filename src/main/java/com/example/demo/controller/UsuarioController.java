package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.Usuario;
import com.example.demo.service.UsuarioService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	@Qualifier("usuarioservice")
	private UsuarioService usuarioService;

	// MOSTRAR TODOS LOS USUARIOS
	@GetMapping("/ListaUsu")
	public ModelAndView listAllUsuarios() {
		ModelAndView mav = new ModelAndView("ListaUsu"); // Nombre de la vista Thymeleaf
		mav.addObject("usuario", usuarioService.listAllUsuario()); // Agregar la lista de empresas
		return mav;
	}

	// BUSCAR USUARIOS SEGÚN TIPO Y VALOR
	@GetMapping("/buscar")
	@ResponseBody
	public List<Usuario> buscarUsuario(@RequestParam("tipo") String tipo, @RequestParam("valor") String valor) {
		if (tipo.equals("todos")) {
			return usuarioService.listAllUsuario();
		} else {
			return usuarioService.buscarPorFiltro(tipo, valor);
		}
	}

	// GUARDAR USUARIO
	@PostMapping("/guardar")
	@ResponseBody
	public String addUsuario(@RequestBody Usuario usuario) {
		usuarioService.addUsuario(usuario);
		return "Usuario guardado correctamente";
	}

	// EDITAR USUARIO
	@GetMapping("/editar/{id}")
	@ResponseBody
	public Usuario getUsuario(@PathVariable("id") int id) {
		return usuarioService.getUsuarioById(id);
	}

	// ELIMINAR USUARIO
	@DeleteMapping("/eliminar/{id}")
	@ResponseBody
	public String deleteUsuario(@PathVariable("id") int id) {
		usuarioService.deleteUsuario(id);
		return "Usuario eliminado correctamente";
	}

	// Página de inicio que redirige al login
	@RequestMapping("/")
	public String redirectToLogin() {
		return "redirect:/usuario/Login";
	}

	// Mostrar formulario de login
	@GetMapping("/Login")
	public ModelAndView showLoginForm() {
		return new ModelAndView("Login");
	}

	@PostMapping("/Login")
	public ModelAndView processLogin(@RequestParam("usuCod") String usuCod, @RequestParam("usuPass") String usuPass,
			HttpSession session) {
		// Aquí se hace la validación contra la base de datos
		Usuario user = usuarioService.validateUser(usuCod, usuPass);
		if (user != null) {
			// Login exitoso
			session.setAttribute("usuario", user); // Guarda el usuario en la sesión
			//return new ModelAndView("redirect:/Inicio");
			return new ModelAndView("inicio"); // se renderiza inicio.html desde /templates

			//return new ModelAndView("redirect:/usuario/ListaUsu"); // Redirige al dashboard
		} else {
			// Login fallido
			ModelAndView mav = new ModelAndView("Login");
			mav.addObject("error", "Código o contraseña incorrectos"); // Muestra el error
			return mav;
		}
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate(); // Invalida toda la sesión
		return "redirect:/usuario/Login"; // Redirige al formulario de login
	}

	@GetMapping("/Inicio")
	public String mostrarInicio() {
	    return "Inicio"; // Nombre del archivo HTML (Inicio.html)
	}
	
}
