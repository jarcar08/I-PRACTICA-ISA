package com.example.demo.repository;
import java.io.Serializable;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.Empresa;

@Repository("empresarepository")
public interface EmpresaRepository extends JpaRepository<Empresa, Serializable>{
	List<Empresa> findByEmprId(int emprId);
	List<Empresa> findByEmprRuc(String emprRuc);
	List<Empresa> findByEmprNombre(String emprNombre);
}