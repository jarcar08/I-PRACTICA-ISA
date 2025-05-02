package com.example.demo.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "area")
public class Area {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "areId")
    private int areId;

    @Column(name = "areNombre")
    private String areNombre;

    @Column(name = "areSalario")
    private double areSalario;

    public Area() {
    }

    public Area(int areId, String areNombre, double areSalario) {
        this.areId = areId;
        this.areNombre = areNombre;
        this.areSalario = areSalario;
    }

    public int getAreId() {
        return areId;
    }

    public void setAreId(int areId) {
        this.areId = areId;
    }

    public String getAreNombre() {
        return areNombre;
    }

    public void setAreNombre(String areNombre) {
        this.areNombre = areNombre;
    }

    public double getAreSalario() {
        return areSalario;
    }

    public void setAreSalario(double areSalario) {
        this.areSalario = areSalario;
    }
}