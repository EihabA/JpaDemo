package com.instantmoney.JpaDemo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Receiver {
	
	@Id
	private int idreceiver;
	private String r_name; 
	private String rlocation;
		
	public int getIdreceiver() {
		return idreceiver;
	}
	public void setIdreceiver(int idreceiver) {
		this.idreceiver = idreceiver;
	}
	public String getR_name() {
		return r_name;
	}
	public void setR_name(String r_name) {
		this.r_name = r_name;
	}
	public String getRlocation() {
		return rlocation;
	}
	public void setRlocation(String rlocation) {
		this.rlocation = rlocation;
	}
	
	@Override
	public String toString() {
		return "Receiver [idreceiver=" + idreceiver + ", r_name=" + r_name + ", rlocation=" + rlocation + "]";
	} 
	
	

}
