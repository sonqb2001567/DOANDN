package com.example.demo.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class DevicesID implements Serializable{
	private Integer id;
	private Integer areaid;
	
	public DevicesID() {
		
	}
	
	public DevicesID(Integer id, Integer areaid) {
		this.id = id;
		this.areaid = areaid;
	}
}
