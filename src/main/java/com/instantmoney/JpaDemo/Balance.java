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
		//BigDecimal balance = getBalance(idsender);
		if (balance!=null)
		{
		balance = balance.add(amount);
		return balance; 
		}
		
		else {
			balance = balance.ZERO ;
			balance = balance.add(amount);
			return balance; 
		}
	}
	
	public BigDecimal withdraw(int idsender, BigDecimal amount)  
	{
		//BigDecimal balance = getBalance(idsender);		
		//BigDecimal newBalance = null;
		if (balance!=null)
		try 
		{
			if (amount.compareTo(balance)<=0);
			 
		}
		catch (java.lang.ArithmeticException e)
		{
			System.out.println("Exception: not enough balance to withdraw");
		}
		
		if (amount.compareTo(balance)>0)
		{
			balance = balance.subtract(amount);
		}
				
		return balance; 
	}
	
	@Override
	public String toString() {
		return "Balance [idsender=" + idsender + ", balance=" + balance + "]";
	}
	

}
