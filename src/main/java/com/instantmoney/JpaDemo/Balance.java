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
	public BigDecimal getBalance(int idsender) {
		return balance;
	}
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	} 
	
	public BigDecimal Topup(int idsender, BigDecimal amount)
	{
		BigDecimal balance = getBalance(idsender);
		BigDecimal newbalance; 
		newbalance = balance.add(amount);
		return newbalance; 
	}
	
	public BigDecimal withdraw(int idsender, BigDecimal amount)  
	{
		BigDecimal balance = getBalance(idsender);		
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
