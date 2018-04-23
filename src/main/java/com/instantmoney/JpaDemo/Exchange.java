package com.instantmoney.JpaDemo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity 
public class Exchange {
	
	@Id
	private int idexchange; 
	private String e_name;
	public int getIdexchange() {
		return idexchange;
	}
	public void setIdexchange(int idexchange) {
		this.idexchange = idexchange;
	}
	public String getE_name() {
		return e_name;
	}
	public void setE_name(String e_name) {
		this.e_name = e_name;
	}
	
	@Override
	public String toString() {
		return "Exchange [idexchange=" + idexchange + ", e_name=" + e_name + "]";
	} 
	
	

}
