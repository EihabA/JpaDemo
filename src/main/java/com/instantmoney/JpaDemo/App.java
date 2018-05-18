package com.instantmoney.JpaDemo;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * to run  money transfer services, add sender, transaction, add receiver and topup balance 
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
       
       EntityManager em = emf.createEntityManager(); 
       
       System.out.println("starting program");
       
   	// list all services available 
    	List<String> services = Arrays.asList("1.Transfer", "2. AddReceiver", "3. TopUp", "4. AddSender");
    	
    	System.out.println("Choose a service :");
    	
    	for (String element : services)
    	{
    		System.out.println(element);
    	}
    	
       	Scanner sc = new Scanner(System.in);
       	
       	String service = sc.next();
       	
       	//Scanner scin = new Scanner(System.in); 
       	
       	//Scanner sca = new Scanner(System.in);
       	
    	// if add sender service is selected
    	
    	if (service.equalsIgnoreCase("addsender"))
    	{
    		//find out his first name and last name and location 
    		Sender newSender = new Sender();
    		//newSender.setIdsender(1);
    		
    		System.out.println("Please enter your first name ");
    		
    		String firstName = sc.next(); 
    		newSender.setS_first_name(firstName);
    		
    		//sc.close();
    		
    		System.out.println("Please enter your last name");
    		
    		String lastName = sc.next();
    		newSender.setS_last_name(lastName);
    		
    		System.out.println("Please enter your location");
    		
    		String slocation = sc.next(); 
    		newSender.setSlocation(slocation);
    		
    		em.getTransaction().begin();
    		
    		em.persist(newSender);
    		
    		em.getTransaction().commit();
    		
    		sc.close();
    		System.out.println("Your user id is " + newSender.getIdsender() + "Name is: "
    		+ newSender.getS_first_name() + " " + newSender.getS_last_name());
    		return; 
    	}
    	// else Find out the user 
    	//Scanner s = new Scanner(System.in); 
    		System.out.println("Input your idSender: ");
    	       int user = sc.nextInt(); 
    	       
    	       // Set the user calling the sender constructor
    	       Sender sender = em.find(Sender.class, user);
    	       
    	       System.out.println("your User name and id is: "+ sender);
    	       
    	       // get the available balance of this user
    			Balance userBalance = em.find(Balance.class,  user); 
    			
    			BigDecimal startB = userBalance.getBalance();
    			
    			System.out.println("Your current Balance is, " + startB);
    	  		
    			// call the balance constructor 
    			Balance b = new Balance(user, startB);
    	
           	// if TopUp service is selected
    	 	
    	if (service.equalsIgnoreCase("TopUP"))
    	{
   		
    		// find out the balance available for the user 
    		
    		System.out.println("Input the topup amount: ");
    		
    		// get the amount to top up 
    		BigDecimal amt = sc.nextBigDecimal(); 
    		
    		// Call the topup method 
    		    		
    		b.Topup(amt);
    		
    		System.out.println("Topping up your balance, total balance now is " 
    		+ b.getBalance() + " for id Sender, " + user);
        	
    		//scin.close();
    		//sca.close();
    		
    	}
    	
    	// If service selected is to transfer money to a receiver 
    	if (service.equalsIgnoreCase("Transfer")) {
    		
    		System.out.println("input the receiver id: ");
    		
    		int idReceiver = sc.nextInt(); 
    		
    		// Construct a Receiver class
    		
    		Receiver receiver = em.find(Receiver.class,  idReceiver); 
    		
    		System.out.println(receiver);//Receiver r = new Receiver(idReceiver,)
    		
    		// get the amount to transfer     		
    		System.out.println("enter the amount you would like to send: ");
    		
    		BigDecimal amountosend = sc.nextBigDecimal(); 
    		
    		Transactions trx = new Transactions(idReceiver, amountosend);
    		
    		List<Exchange> exchange = em.createNativeQuery("select * from instant_money_transfer.exchange", Exchange.class)
    				.getResultList();
    		
    		System.out.println(exchange);
    		
    		System.out.println("Select which Exchange: ");
    		    		
    		//Scanner sxc = new Scanner(System.in); 
    		
    		int idexc = sc.nextInt(); 
    		
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
    		
    		//sxc.close();
    		
    	}
    	
    	sc.close();
        	   	
    }
}
