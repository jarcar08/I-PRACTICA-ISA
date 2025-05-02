package com.example.demo.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "empresa")
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emprId")
    private int emprId;

    @Column(name = "emprRuc")
    private String emprRuc;

    @Column(name = "emprNombre")
    private String emprNombre;

    @Column(name = "emprDireccion")
    private String emprDireccion;

	public Empresa() {
	}
	
	public Empresa(int emprId, String emprRuc, String emprNombre, String emprDireccion) {
		this.emprId = emprId;
		this.emprRuc = emprRuc;
		this.emprNombre = emprNombre;
		this.emprDireccion = emprDireccion;
	}
	
	public int getEmprId() {
		return emprId;
	}
	public void setEmprId(int emprId) {
		this.emprId = emprId;
	}
	public String getEmprRuc() {
		return emprRuc;
	}
	public void setEmprRuc(String emprRuc) {
		this.emprRuc = emprRuc;
	}
	public String getEmprNombre() {
		return emprNombre;
	}
	public void setEmprNombre(String emprNombre) {
		this.emprNombre = emprNombre;
	}
	public String getEmprDireccion() {
		return emprDireccion;
	}
	public void setEmprDireccion(String emprDireccion) {
		this.emprDireccion = emprDireccion;
	}
}