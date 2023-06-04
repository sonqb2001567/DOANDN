package com.example.demo.model;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;


@Entity
@Table(name = "Mois")
@IdClass(MoisId.class)
public class Mois {
	@Id
	private Integer areaid;
	
	@Id
	private Timestamp rectime;
	
	@Column(name = "mois")
	private Float mois;
	
	public Mois() {
        // no-argument constructor
    }

	public Mois(Integer areaid, Timestamp rectime, Float mois) {
		super();
		this.areaid = areaid;
		this.rectime = rectime;
		this.mois = mois;
	}

	public Integer getAreaid() {
		return areaid;
	}

	public void setAreaId(Integer areaid) {
		this.areaid = areaid;
	}

	public Timestamp getRectime() {
		return rectime;
	}

	public void setRectime(Timestamp rectime) {
		this.rectime = rectime;
	}

	public Float getMois() {
		return mois;
	}

	public void setMois(Float mois) {
		this.mois = mois;
	}	
}