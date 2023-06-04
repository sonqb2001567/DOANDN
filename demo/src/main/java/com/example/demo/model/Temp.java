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
@Table(name = "Temp")
@IdClass(TempId.class)
public class Temp {
	@Id
	private Integer areaid;
	
	@Id
	private Timestamp rectime;
	
	@Column(name = "temp")
	private Float temp;
	
	public Temp() {
        // no-argument constructor
    }

	public Temp(Integer areaid, Timestamp rectime, Float temp) {
		super();
		this.areaid = areaid;
		this.rectime = rectime;
		this.temp = temp;
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

	public Float getTemp() {
		return temp;
	}

	public void setTemp(Float temp) {
		this.temp = temp;
	}

	
}