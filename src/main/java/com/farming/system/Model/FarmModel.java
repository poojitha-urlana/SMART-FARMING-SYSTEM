package com.farming.system.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class FarmModel {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)

	private  long id;
	private String name;
	private float location;
	private  int size;
    private String farmStatus;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getLocation() {
		return location;
	}
	public void setLocation(float location) {
		this.location = location;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public String getFarmStatus() {
		return farmStatus;
	}
	public void setFarmStatus(String farmStatus) {
		this.farmStatus = farmStatus;
	}
}
	