package com.example.demo.repository;
import java.io.Serializable;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.Usuario;

@Repository("usuariorepository")
public interface UsuarioRepository extends JpaRepository<Usuario, Serializable>{
	List<Usuario> findByIdusuario(int idusuario);
	List<Usuario> findByUsuCod(String usuCod);
	List<Usuario> findByUsuEmpId(int usuEmpId);
	Usuario findByUsuCodAndUsuPass(String usuCod, String usuPass);
}