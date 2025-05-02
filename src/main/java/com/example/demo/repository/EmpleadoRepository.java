package com.example.demo.repository;
import java.io.Serializable;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.Empleado;

@Repository("empleadorepository")
public interface EmpleadoRepository extends JpaRepository<Empleado, Serializable>{
	List<Empleado> findByEmpDni(String empDni);
	List<Empleado> findByEmpNombres(String empNombres);
	List<Empleado> findByEmpApellidoPaterno(String empApellidoPaterno);
	List<Empleado> findByEmpApellidoMaterno(String empApellidoMaterno);
}