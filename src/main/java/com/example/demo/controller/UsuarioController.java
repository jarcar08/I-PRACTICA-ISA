package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.example.demo.entity.Usuario;
import com.example.demo.service.UsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	@Qualifier("usuarioservice")
	private UsuarioService usuarioService;

	// MOSTRAR TODOS LOS USUARIOS
	@GetMapping("/lista")
	@ResponseBody
	public List<Usuario> listAllUsuarios() {
		List<Usuario> usuarios = usuarioService.listAllUsuario();
		if (usuarios == null || usuarios.isEmpty()) {
			System.out.println("No se encontraron usuarios en la base de datos.");
		}
		return usuarios;
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
}