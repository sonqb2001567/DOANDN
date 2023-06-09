package com.example.demo.model;

import org.hibernate.type.descriptor.jdbc.VarcharJdbcType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Feeds")
public class Feeds {
	@Id
	private int feedid;
	
	@Column(name = "feedname")
	private String feedname;
	
	@Column(name = "feedkey")
	private String feedkey;

	public Feeds(int feedid, String feedname, String feedkey) {
		super();
		this.feedid = feedid;
		this.feedname = feedname;
		this.feedkey = feedkey;
	}

	@Override
	public String toString() {
		return "Feeds [feedid=" + feedid + ", feedname=" + feedname + ", feedkey=" + feedkey + "]";
	}

	
	
	
}
