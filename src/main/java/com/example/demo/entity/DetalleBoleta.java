package com.example.demo.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "detalle_boleta")
public class DetalleBoleta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "detId")
    private int detId;

    @Column(name = "detboId")
    private int detboId;

    @Column(name = "detTipoMonto")
    private String detTipoMonto;

    @Column(name = "detDescrip")
    private String detDescrip;

    @Column(name = "detMonto")
    private double detMonto;

	public DetalleBoleta() {
	}
	
	public DetalleBoleta(int detId, int detboId, String detTipoMonto, String detDescrip, double detMonto) {
		this.detId = detId;
		this.detboId = detboId;
		this.detTipoMonto = detTipoMonto;
		this.detDescrip = detDescrip;
		this.detMonto = detMonto;
	}
	
	public int getDetId() {
		return detId;
	}
	public void setDetId(int detId) {
		this.detId = detId;
	}
	public int getDetboId() {
		return detboId;
	}
	public void setDetboId(int detboId) {
		this.detboId = detboId;
	}
	public String getDetTipoMonto() {
		return detTipoMonto;
	}
	public void setDetTipoMonto(String detTipoMonto) {
		this.detTipoMonto = detTipoMonto;
	}
	public String getDetDescrip() {
		return detDescrip;
	}
	public void setDetDescrip(String detDescrip) {
		this.detDescrip = detDescrip;
	}
	public double getDetMonto() {
		return detMonto;
	}
	public void setDetMonto(double detMonto) {
		this.detMonto = detMonto;
	}
}