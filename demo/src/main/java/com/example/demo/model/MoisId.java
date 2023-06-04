package com.example.demo.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class MoisId implements Serializable{
	private Integer areaid;
	private Timestamp rectime;
	
	public MoisId() {
		
	}
	
	public MoisId(Integer areaid, Timestamp rectime) {
		this.areaid = areaid;
		this.rectime = rectime;
	}
}
