package com.example.demo.DTO;

import java.sql.Timestamp;

public class MoisDTO {
	private int areaid;
	private Timestamp rectime;
	private float mois;
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
	
	
	public MoisDTO(int areaid, Timestamp rectime, float mois) {
		super();
		this.areaid = areaid;
		this.rectime = rectime;
		this.mois = mois;
	}
	public MoisDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public float getMois() {
		return mois;
	}
	public void setMois(float mois) {
		this.mois = mois;
	}
	
	@Override
	public String toString() {
		return "MoisDTO [areaid=" + areaid + ", rectime=" + rectime + ", mois=" + mois + "]";
	}
	
	
}
