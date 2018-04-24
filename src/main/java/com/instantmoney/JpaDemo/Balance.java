package com.instantmoney.JpaDemo;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Balance {
	
	@Id
	private int idsender; 
	private BigDecimal balance;
	
	public int getIdsender() {
		return idsender;
	}
	public void setIdsender(int idsender) {
		this.idsender = idsender;
	}
	public BigDecimal getBalance() {
		return balance;
	}
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	} 
	
	public BigDecimal Topup(BigDecimal amount)
	{
		BigDecimal newbalance; 
		newbalance = balance.add(amount);
		return newbalance; 
	}
	
	public BigDecimal withdraw(BigDecimal amount) {
		
		BigDecimal newBalance = null;
	 
		if (amount.compareTo(balance)>0)
		{
			newBalance = balance.subtract(amount); 
//			return newBalance;
		}
		
		return newBalance; 
	}
	@Override
	public String toString() {
		return "Balance [idsender=" + idsender + ", balance=" + balance + "]";
	}
	

}
