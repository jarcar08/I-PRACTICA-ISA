package com.example.demo.entity;
import java.util.Date;
import jakarta.persistence.*;

@Entity
@Table(name = "contrato")
public class Contrato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "conId")
    private int conId;

    @Column(name = "conEmpId")
    private int conEmpId;

    @Column(name = "conModContId")
    private int conModContId;

    @Column(name = "conAreaId")
    private int conAreaId;

    @Column(name = "conJornId")
    private int conJornId;

    @Column(name = "conFechaInicio")
    private Date conFechaInicio;

    @Column(name = "conFechaFin")
    private Date conFechaFin;

    @Column(name = "conDiasTrabajo")
    private int conDiasTrabajo;

    @Column(name = "conEstado")
    private Byte conEstado;

    // Constructor vacío
    public Contrato() {
    }

    // Constructor con parámetros
    public Contrato(int conId, int conEmpId, int conModContId, int conAreaId, int conJornId,
                    Date conFechaInicio, Date conFechaFin, int conDiasTrabajo, Byte conEstado) {
        this.conId = conId;
        this.conEmpId = conEmpId;
        this.conModContId = conModContId;
        this.conAreaId = conAreaId;
        this.conJornId = conJornId;
        this.conFechaInicio = conFechaInicio;
        this.conFechaFin = conFechaFin;
        this.conDiasTrabajo = conDiasTrabajo;
        this.conEstado = conEstado;
    }

    public int getConId() {
        return conId;
    }
    public void setConId(int conId) {
        this.conId = conId;
    }
    public int getConEmpId() {
        return conEmpId;
    }
    public void setConEmpId(int conEmpId) {
        this.conEmpId = conEmpId;
    }
    public int getConModContId() {
        return conModContId;
    }
    public void setConModContId(int conModContId) {
        this.conModContId = conModContId;
    }
    public int getConAreaId() {
        return conAreaId;
    }
    public void setConAreaId(int conAreaId) {
        this.conAreaId = conAreaId;
    }
    public int getConJornId() {
        return conJornId;
    }
    public void setConJornId(int conJornId) {
        this.conJornId = conJornId;
    }
    public Date getConFechaInicio() {
        return conFechaInicio;
    }
    public void setConFechaInicio(Date conFechaInicio) {
        this.conFechaInicio = conFechaInicio;
    }
    public Date getConFechaFin() {
        return conFechaFin;
    }
    public void setConFechaFin(Date conFechaFin) {
        this.conFechaFin = conFechaFin;
    }
    public int getConDiasTrabajo() {
        return conDiasTrabajo;
    }
    public void setConDiasTrabajo(int conDiasTrabajo) {
        this.conDiasTrabajo = conDiasTrabajo;
    }
    public Byte getConEstado() {
        return conEstado;
    }
    public void setConEstado(Byte conEstado) {
        this.conEstado = conEstado;
    }
}