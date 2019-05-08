package org.abccourse.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String code;
	private String name;
	
	@Column(name="created_time", insertable=false, updatable = false)
	private Timestamp createdTime;
	
	@Column(name="modified_time", insertable=false, updatable = false)
	private Timestamp modifiedTime;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Timestamp getCreatedTime() {
		return createdTime;
	}
	
	public void setCreatedTime(Timestamp createdTime) {
		this.createdTime = createdTime;
	}
	
	public Timestamp getModifiedTime() {
		return modifiedTime;
	}
	
	public void setModifiedTime(Timestamp modifiedTime) {
		this.modifiedTime = modifiedTime;
	}
	
}