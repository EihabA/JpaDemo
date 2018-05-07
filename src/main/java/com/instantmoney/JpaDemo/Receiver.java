package com.instantmoney.JpaDemo;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Receiver {
	
	@Id
	private int idreceiver;
	private String r_name; 
	private String rlocation;
	private BigDecimal balance; 
		
	public Receiver (int idreceiver, BigDecimal balance)
	{
		this.idreceiver = idreceiver; 
		this.balance = balance; 
	
	}
	
	public Receiver()
	{
		
	}
	
	public BigDecimal updateBalance (BigDecimal amount)
	{
		balance = balance.add(amount); 
		return balance; 
	}
	
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
	
	public BigDecimal getBalance() {
		return balance;
	}
	
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	
	public String getRlocation() {
		return rlocation;
	}
	public void setRlocation(String rlocation) {
		this.rlocation = rlocation;
	}
	
	@Override
	public String toString() {
		return "Receiver [idreceiver=" + idreceiver + ", r_name=" + r_name + ", balance= " + balance + ", rlocation=" + rlocation + "]";
	} 
	
	

}
