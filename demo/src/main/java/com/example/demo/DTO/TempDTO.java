package com.example.demo.DTO;

import java.sql.Timestamp;

public class TempDTO {
	private int areaid;
	private Timestamp rectime;
	private float temp;
	public int getAreaid() {
		return areaid;
	}
	public void setAreaid(int areaid) {
		this.areaid = areaid;
	}
	public Timestamp getRectime() {
		return rectime;
	}
	public void setRectime(Timestamp rectime) {
		this.rectime = rectime;
	}
	public float getTemp() {
		return temp;
	}
	public void setTemp(float temp) {
		this.temp = temp;
	}
	public TempDTO(int areaid, Timestamp rectime, float temp) {
		super();
		this.areaid = areaid;
		this.rectime = rectime;
		this.temp = temp;
	}
	public TempDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "TempDTO [areaid=" + areaid + ", rectime=" + rectime + ", temp=" + temp + "]";
	}
	
	
}
