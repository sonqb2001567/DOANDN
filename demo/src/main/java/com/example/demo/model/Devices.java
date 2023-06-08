package com.example.demo.model;

import org.hibernate.type.descriptor.jdbc.VarcharJdbcType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.val;

@Entity
@Table(name = "Devices")
@IdClass(DevicesID.class)
public class Devices {
	@Id
	private int id;
	
	@Column(name = "devicename")
	private String devicename;
	
	@Id
	private Integer areaid;
	
	@Column(name = "devicetype")
	private String devicetype;
	
	@Column(name = "feedname")
	private String feedname;
	
	public Devices() {
	
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDevicename() {
		return devicename;
	}

	public void setDevicename(String devicename) {
		this.devicename = devicename;
	}

	public Integer getAreaid() {
		return areaid;
	}

	public void setAreaid(Integer areaid) {
		this.areaid = areaid;
	}

	public String getDevicetype() {
		return devicetype;
	}

	public void setDevicetype(String devicetype) {
		this.devicetype = devicetype;
	}

	public String getFeedname() {
		return feedname;
	}

	public void setFeedname(String feedname) {
		this.feedname = feedname;
	}

	public Devices(int id, String devicename, int areaid, String devicetype, String feedname) {
		super();
		this.id = id;
		this.devicename = devicename;
		this.areaid = areaid;
		this.devicetype = devicetype;
		this.feedname = feedname;
	}
	
	
}
