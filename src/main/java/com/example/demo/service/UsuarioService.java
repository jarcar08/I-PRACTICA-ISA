package com.example.demo.service;
import java.util.List;
import com.example.demo.entity.Usuario;

public interface UsuarioService {
	List<Usuario> listAllUsuario();
	Usuario addUsuario(Usuario usuario);
    void deleteUsuario(int id);
    Usuario getUsuarioById(int id);
    List<Usuario> buscarPorFiltro(String tipo, String valor);
    public abstract Usuario validateUser(String usuCod, String usuPass);
}