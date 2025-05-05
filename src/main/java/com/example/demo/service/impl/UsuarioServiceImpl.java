package com.example.demo.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Usuario;
import com.example.demo.repository.UsuarioRepository;
import com.example.demo.service.UsuarioService;

@Service("usuarioservice")
public class UsuarioServiceImpl implements UsuarioService{
	@Autowired
	@Qualifier("usuariorepository")
	private UsuarioRepository usuarioRepository;

	@Override
	public List<Usuario> listAllUsuario() {
		return usuarioRepository.findAll();
	}

	@Override
	public Usuario addUsuario(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	@Override
	public void deleteUsuario(int id) {
		usuarioRepository.deleteById(id);
	}

	@Override
	public Usuario getUsuarioById(int id) {
		return usuarioRepository.findById(id).orElse(null);
	}

	@Override
	public List<Usuario> buscarPorFiltro(String tipo, String valor) {
		switch (tipo) {
        case "conId":
            return usuarioRepository.findByIdusuario(Integer.parseInt(valor));
        case "conIdEmp":
            return usuarioRepository.findByUsuCod(valor);
        case "conIdModEmpl":
            return usuarioRepository.findByUsuEmpId(Integer.parseInt(valor));
        default:
            return listAllUsuario();
		}
	}

	@Override
	public Usuario validateUser(String usuCod, String usuPass) {
		// TODO Auto-generated method stub
		return usuarioRepository.findByUsuCodAndUsuPass(usuCod, usuPass);
	}
}