package com.example.demo.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "mod_contrato")
public class ModContrato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "modconId")
    private int modconId;

    @Column(name = "modcontipo")
    private String modcontipo;

	public ModContrato() {
	}

	public ModContrato(int modconId, String modcontipo) {
		this.modconId = modconId;
		this.modcontipo = modcontipo;
	}

	public int getModconId() {
		return modconId;
	}
	public void setModconId(int modconId) {
		this.modconId = modconId;
	}
	public String getModcontipo() {
		return modcontipo;
	}
	public void setModcontipo(String modcontipo) {
		this.modcontipo = modcontipo;
	}
}