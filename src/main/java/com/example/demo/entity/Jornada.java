package com.example.demo.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "jornada")
public class Jornada {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "jornId")
    private int jornId;

    @Column(name = "jornTipo")
    private String jornTipo;

	public Jornada() {
	}

	public Jornada(int jornId, String jornTipo) {
		this.jornId = jornId;
		this.jornTipo = jornTipo;
	}

	public int getJornId() {
		return jornId;
	}
	public void setJornId(int jornId) {
		this.jornId = jornId;
	}
	public String getJornTipo() {
		return jornTipo;
	}
	public void setJornTipo(String jornTipo) {
		this.jornTipo = jornTipo;
	}
}