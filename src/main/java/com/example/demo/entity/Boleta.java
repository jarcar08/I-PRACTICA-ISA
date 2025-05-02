package com.example.demo.entity;
import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "boleta")
public class Boleta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bolId")
    private int bolId;

    @Column(name = "bolFechaEmision")
    private Date bolFechaEmision;

    @Column(name = "bolMesPago")
    private String bolMesPago;

    @Column(name = "bolImporteTotal")
    private double bolImporteTotal;

    @Column(name = "bolempId")
    private int bolempId;

    @Column(name = "bolempreId")
    private int bolempreId;

	public Boleta(){
	}
	
	public Boleta(int bolId, Date bolFechaEmision, String bolMesPago, double bolImporteTotal, int bolempId,
			int bolempreId) {
		this.bolId = bolId;
		this.bolFechaEmision = bolFechaEmision;
		this.bolMesPago = bolMesPago;
		this.bolImporteTotal = bolImporteTotal;
		this.bolempId = bolempId;
		this.bolempreId = bolempreId;
	}
	public int getBolId() {
		return bolId;
	}
	public void setBolId(int bolId) {
		this.bolId = bolId;
	}
	public Date getBolFechaEmision() {
		return bolFechaEmision;
	}
	public void setBolFechaEmision(Date bolFechaEmision) {
		this.bolFechaEmision = bolFechaEmision;
	}
	public String getBolMesPago() {
		return bolMesPago;
	}
	public void setBolMesPago(String bolMesPago) {
		this.bolMesPago = bolMesPago;
	}
	public double getBolImporteTotal() {
		return bolImporteTotal;
	}
	public void setBolImporteTotal(double bolImporteTotal) {
		this.bolImporteTotal = bolImporteTotal;
	}
	public int getBolempId() {
		return bolempId;
	}
	public void setBolempId(int bolempId) {
		this.bolempId = bolempId;
	}
	public int getBolempreId() {
		return bolempreId;
	}
	public void setBolempreId(int bolempreId) {
		this.bolempreId = bolempreId;
	}
}