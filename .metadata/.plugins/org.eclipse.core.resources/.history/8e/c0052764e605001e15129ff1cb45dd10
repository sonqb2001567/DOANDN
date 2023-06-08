package com.example.demo.model;

import org.hibernate.type.descriptor.jdbc.VarcharJdbcType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Area")
public class Area {
	@Id
	private int id;
	
	@Column(name = "area_name")
	private String area_name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getArea_name() {
		return area_name;
	}

	public void setArea_name(String area_name) {
		this.area_name = area_name;
	}

	public Area(int id, String area_name) {
		super();
		this.id = id;
		this.area_name = area_name;
	}
	
	
}
