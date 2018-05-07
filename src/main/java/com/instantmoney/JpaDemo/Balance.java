package com.instantmoney.JpaDemo;

import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Id;
import javax.persistence.Persistence;

@Entity
public class Balance
{
	
	private int idsender; 
	private BigDecimal balance;

	
public Balance(int id, BigDecimal startBalance)
	{
		this.idsender = id;
		this.balance = startBalance;
	}

public Balance()
{
	
}
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");

	@Id	
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
	
	public synchronized void Topup(BigDecimal amount)
	{
		EntityManager em = emf.createEntityManager();
        	    
		if (balance!=null)
		{
		balance = balance.add(amount);
		
		}
		
		else {
			balance = balance.ZERO ;
			balance = balance.add(amount);
		}
		
		setBalance(balance);
	
		em.getTransaction().begin();
		
		em.createQuery("update Balance set balance = " +  balance + "where idsender=" + idsender)
	    .executeUpdate();
	    
		em.flush();
		em.getTransaction().commit();
		em.close();
	}
	
	public synchronized void  withdraw(BigDecimal amount)  
	{
		System.out.println("Entering the withdraw method: ......." + amount);
		
		EntityManager em = emf.createEntityManager();
		
		System.out.println(amount.compareTo(balance));
		
		if (balance!=null)
		try 
		{
			
			if (amount.compareTo(balance)>0);
			 
		}
		catch (java.lang.ArithmeticException e)
		{
			System.out.println("Exception: not enough balance to withdraw");
		}
		
		if (amount.compareTo(balance)<=0)
		{
			balance = balance.subtract(amount);
		}
		 
		setBalance(balance);
		
		System.out.println("balance after subtraction: " + balance);
		
		em.getTransaction().begin();
		
		em.createQuery("update Balance set balance = " + balance + "where idsender=" + idsender)
	    .executeUpdate();
		
		em.flush();
			
		em.getTransaction().commit();
		em.close();
	}
	
	@Override
	public String toString() {
		return "Balance [idsender=" + idsender + ", balance=" + balance + "]";
	}

}
