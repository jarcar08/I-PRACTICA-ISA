package com.example.demo.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Empleado;
import com.example.demo.repository.EmpleadoRepository;
import com.example.demo.service.EmpleadoService;

@Service("empleadoservice")
public class EmpleadoServiceImpl implements EmpleadoService{
	
	@Autowired
	@Qualifier("empleadorepository")
	private EmpleadoRepository empleadoRepository;
	
	@Override
	public List<Empleado> listAllEmpleado() {
		return empleadoRepository.findAll();
	}

	@Override
	public Empleado addEmpleado(Empleado empleado) {
		return empleadoRepository.save(empleado);
	}

	@Override
	public void deleteEmpleado(int id) {
		empleadoRepository.deleteById(id);
	}

	@Override
	public Empleado getEmpleadoById(int id) {
		return empleadoRepository.findById(id).orElse(null);
	}

	@Override
	public List<Empleado> buscarPorFiltro(String tipo, String valor) {
	    switch (tipo) {
	        case "empDni":
	            return empleadoRepository.findByEmpDni(valor);
	        case "empApellidoPaterno":
	            return empleadoRepository.findByEmpApellPaterno(valor);
	        case "empApellidoMaterno":
	            return empleadoRepository.findByEmpApellMaterno(valor);
	        case "empNombres":
	            return empleadoRepository.findByEmpNombres(valor);
	        default:
	            return empleadoRepository.findAll();
	    }
	}
}