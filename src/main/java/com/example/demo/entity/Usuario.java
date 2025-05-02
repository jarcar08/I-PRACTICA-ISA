package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idusuario")
	private int idusuario;

	@Column(name = "usuCod", unique = true)
	private String usuCod;

	@Column(name = "usuPass")
	private String usuPass;

	@Column(name = "usuEmpId")
	private int usuEmpId;

	public Usuario() {
	}

	public Usuario(int idusuario, String usuCod, String usuPass, int usuEmpId) {
		this.idusuario = idusuario;
		this.usuCod = usuCod;
		this.usuPass = usuPass;
		this.usuEmpId = usuEmpId;

	}

	public int getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
	}

	public String getUsuCod() {
		return usuCod;
	}

	public void setUsuCod(String usuCod) {
		this.usuCod = usuCod;
	}

	public String getUsuPass() {
		return usuPass;
	}

	public void setUsuPass(String usuPass) {
		this.usuPass = usuPass;
	}

	public int getUsuEmpId() {
		return usuEmpId;
	}

	public void setUsuEmpId(int usuEmpId) {
		this.usuEmpId = usuEmpId;
	}

}