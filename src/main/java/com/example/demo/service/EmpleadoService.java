package com.example.demo.service;
import java.util.List;
import com.example.demo.entity.Empleado;

public interface EmpleadoService {
	List<Empleado> listAllEmpleado();
	Empleado addEmpleado(Empleado empleado);
    void deleteEmpleado(int id);
    Empleado getEmpleadoById(int id);
    List<Empleado> buscarPorFiltro(String tipo, String valor);
}