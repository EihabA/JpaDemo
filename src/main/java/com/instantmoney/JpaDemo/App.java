package com.instantmoney.JpaDemo;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * to connect to Mysql database instant Money and update the senders table
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
    	
    	List<String> services = Arrays.asList("1.Transfer", "2. AddReceiver", "3. TopUp");
    	
    	System.out.println("Choose a service :");
    	
    	for (String element : services)
    	{
    		System.out.println(element);
    	}
    	
    	Scanner sc = new Scanner(System.in);
    	
    	String service = sc.next();
    	
    	Scanner scin = new Scanner(System.in); 
    	
    	Scanner sca = new Scanner(System.in);
    	 	
    	if (service.equalsIgnoreCase("TopUP"))
    	{
    		EntityManager em = emf.createEntityManager();
    		
    		System.out.println("input sender id: ");
    		
    		int id = scin.nextInt(); 
    		
    		Balance userBalance = em.find(Balance.class,  id); 
    		
    		BigDecimal startB = userBalance.getBalance();
    		
    		System.out.println("Your current Balance is, " + startB);
       		
    		Balance b = new Balance(id, startB);
    		
    		System.out.println("Input the topup amount: ");
    		
    		BigDecimal amt = sca.nextBigDecimal(); 
    		    		
    		b.Topup(amt);
    		
    		System.out.println("Topping up your balance, total balance now is " 
    		+ b.getBalance() + " for id Sender, " + id);
        	
    		scin.close();
    		sca.close();
    		sc.close(); 
    	}
        	   	
    }
}
