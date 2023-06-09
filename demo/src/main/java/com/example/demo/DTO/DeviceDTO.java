package com.example.demo.DTO;

public class DeviceDTO {
	private Integer id;
	private String devicename;
	private Integer areaid;
	private String devicetype;
	private String feedname;
	
	public DeviceDTO() {
		super();
	}
	public DeviceDTO(Integer id, String devicename, Integer areaid, String devicetype, String feedname) {
		super();
		this.devicename = devicename;
		this.areaid = areaid;
		this.devicetype = devicetype;
		this.feedname = feedname;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
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
	@Override
	public String toString() {
		return "DeviceDTO [devicename=" + devicename + ", areaid=" + areaid + ", devicetype="
				+ devicetype + ", feedname=" + feedname + "]";
	}
			
}
