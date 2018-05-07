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
       
       EntityManager em = emf.createEntityManager(); 
       
       // Find out the user 
       Scanner s = new Scanner(System.in); 
       
       System.out.println("Input your idSender: ");
       int user = s.nextInt(); 
       
       // Set the user calling the sender constructor
       Sender sender = em.find(Sender.class, user);
       
       System.out.println("your User name and id is: "+ sender);
       
       // get the available balance of this user
		Balance userBalance = em.find(Balance.class,  user); 
		
		BigDecimal startB = userBalance.getBalance();
		
		System.out.println("Your current Balance is, " + startB);
  		
		// call the balance constructor 
		Balance b = new Balance(user, startB);
    	
       // list all services available 
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
    	
    	// if TopUp service is selected
    	 	
    	if (service.equalsIgnoreCase("TopUP"))
    	{
   		
    		// find out the balance available for the user 
    		
    		System.out.println("Input the topup amount: ");
    		
    		// get the amount to top up 
    		BigDecimal amt = sca.nextBigDecimal(); 
    		
    		// Call the topup method 
    		    		
    		b.Topup(amt);
    		
    		System.out.println("Topping up your balance, total balance now is " 
    		+ b.getBalance() + " for id Sender, " + user);
        	
    		scin.close();
    		sca.close();
    		sc.close(); 
    	}
    	
    	// If service selected is to transfer money to a receiver 
    	if (service.equalsIgnoreCase("Transfer")) {
    		
    		System.out.println("input the receiver id: ");
    		
    		int idReceiver = scin.nextInt(); 
    		
    		// Construct a Receiver class
    		
    		Receiver receiver = em.find(Receiver.class,  idReceiver); 
    		
    		System.out.println(receiver);//Receiver r = new Receiver(idReceiver,)
    		
    		// get the amount to transfer     		
    		System.out.println("enter the amount you would like to send: ");
    		
    		BigDecimal amountosend = sca.nextBigDecimal(); 
    		
    		Transactions trx = new Transactions(idReceiver, amountosend);
    		
    		List<Exchange> exchange = em.createNativeQuery("select * from instant_money_transfer.exchange", Exchange.class)
    				.getResultList();
    		
    		System.out.println(exchange);
    		
    		System.out.println("Select which Exchange: ");
    		    		
    		Scanner sxc = new Scanner(System.in); 
    		
    		int idexc = sxc.nextInt(); 
    		
    		trx.setIdexchange(idexc);
    		trx.setIdsender(user);
    		
    		b.withdraw(amountosend);
    		
    		BigDecimal initialReceiverBalance = receiver.getBalance(); 
    		
    		Receiver r = new Receiver (idReceiver, initialReceiverBalance);
    				
    		BigDecimal newReceiverBalance=r.updateBalance(amountosend);
    		
    		System.out.println("Receiver balance: " + newReceiverBalance);
    		
    		r.setBalance(newReceiverBalance);
    		
    		em.getTransaction().begin();
    		
    		em.createQuery("update Receiver set balance = " + newReceiverBalance + "where idReceiver=" + idReceiver)
    	    .executeUpdate();
    		
    		em.flush();
    			
    		em.getTransaction().commit();
    		em.close();
    		
    		System.out.println("the balance is now: " + b.getBalance());
    		
    		sxc.close();
    		
    	}
    	
    	s.close();
        	   	
    }
}
