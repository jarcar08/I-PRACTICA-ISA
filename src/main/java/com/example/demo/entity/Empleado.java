package com.example.demo.entity;
import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "empleado")
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "empId")
    private int empId;

    @Column(name = "empDni", unique = true)
    private String empDni;

    @Column(name = "empApellPaterno")
    private String empApellPaterno;

    @Column(name = "empApellMaterno")
    private String empApellMaterno;

    @Column(name = "empNombres")
    private String empNombres;

    @Column(name = "empGenero")
    private String empGenero; // 'F' o 'M'

    @Column(name = "empCorreo")
    private String empCorreo;

    @Column(name = "empFechaNacimiento")
    private Date empFechaNacimiento;

    @Column(name = "empEstado")
    private Byte empEstado;

	public Empleado() {
	}
	
	public Empleado(int empId, String empDni, String empApellPaterno, String empApellMaterno, String empNombres,
			String empGenero, String empCorreo, Date empFechaNacimiento, Byte empEstado) {
		this.empId = empId;
		this.empDni = empDni;
		this.empApellPaterno = empApellPaterno;
		this.empApellMaterno = empApellMaterno;
		this.empNombres = empNombres;
		this.empGenero = empGenero;
		this.empCorreo = empCorreo;
		this.empFechaNacimiento = empFechaNacimiento;
		this.empEstado = empEstado;
	}
	
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpDni() {
		return empDni;
	}
	public void setEmpDni(String empDni) {
		this.empDni = empDni;
	}
	public String getEmpApellPaterno() {
		return empApellPaterno;
	}
	public void setEmpApellPaterno(String empApellPaterno) {
		this.empApellPaterno = empApellPaterno;
	}
	public String getEmpApellMaterno() {
		return empApellMaterno;
	}
	public void setEmpApellMaterno(String empApellMaterno) {
		this.empApellMaterno = empApellMaterno;
	}
	public String getEmpNombres() {
		return empNombres;
	}
	public void setEmpNombres(String empNombres) {
		this.empNombres = empNombres;
	}
	public String getEmpGenero() {
		return empGenero;
	}
	public void setEmpGenero(String empGenero) {
		this.empGenero = empGenero;
	}
	public String getEmpCorreo() {
		return empCorreo;
	}
	public void setEmpCorreo(String empCorreo) {
		this.empCorreo = empCorreo;
	}
	public Date getEmpFechaNacimiento() {
		return empFechaNacimiento;
	}
	public void setEmpFechaNacimiento(Date empFechaNacimiento) {
		this.empFechaNacimiento = empFechaNacimiento;
	}
	public Byte getEmpEstado() {
		return empEstado;
	}
	public void setEmpEstado(Byte empEstado) {
		this.empEstado = empEstado;
	}
}