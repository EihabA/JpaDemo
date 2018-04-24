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
    	//Sender s = new Sender();
    	
    	//Receiver r = new Receiver(); 
    	
    	//Exchange e = new Exchange();
    	
    	/*e.setIdexchange(6);
    	e.setE_name("Barclays");*/
    	
/*    	r.setIdreceiver(5);
    	r.setR_name("Shobashy Yodi");
    	r.setRlocation("Hong Kong");*/
    	
    	//Transactions t = new Transactions(); 
    	
    	/*t.setIdtrans(10);
    	t.setIdsender(3);
    	t.setIdreceiver(1);
    	t.setIdexchange(4);
    	t.setAmount(185.0);
    	t.setTimestamp(LocalDateTime.now());*/
    	
/*    	Balance b = new Balance(); 
    	BigDecimal value = new BigDecimal("5500");
    	b.setIdsender(7);
    	b.setBalance(value);*/
    
    	
       	EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
    	
    	EntityManager em = emf.createEntityManager();
    	
    	/*em.getTransaction().begin();
    	em.persist(s);
    	em.getTransaction().commit();
    	*/
/*       	em.getTransaction().begin();
    	em.persist(b);
    	em.getTransaction().commit();*/
    	
        //Sender sender = em.find(Sender.class,6);
        
      //System.out.println(b.toString());
    	
    		
    	//List<String> senders = new ArrayList<String>();
    	
    	//senders.add("Eihab");
    	
    	List<Sender> results = 
    			em.createNativeQuery("select s.idsender, s.s_first_name, s.s_last_name, "
    					+ "s.slocation from instant_money_transfer.sender s", 
    					Sender.class).getResultList(); 
    	
    	for (Sender element : results)
    	{
    		System.out.println(element);
    	}
    	
    	List<String> services = Arrays.asList("Transfer", "addReceiver", "TopUp");
    	
    	System.out.println("Chose a service:" + services);
    	
    	Scanner sc = new Scanner(System.in);
    	
    	String service = sc.next();
    	
    	Scanner scin = new Scanner(System.in); 
    	
    	Scanner sca = new Scanner(System.in);
    	 	
    	if (service.equalsIgnoreCase("TopUP"))
    	{
    		System.out.println("input sender id: ");
    		
    		int id = scin.nextInt(); 
    		
    		System.out.println("Input amount: ");
    		
    		BigDecimal amt = sca.nextBigDecimal(); 
    		
    		Balance b = new Balance(); 
    		
    		BigDecimal nbal; 
    		
    		nbal = b.Topup(id, amt);
    		
    		System.out.println("New Balance :" + nbal);
    		
    		System.out.println("Service Selected: "+ service + ", idsender " + id + ", amount " + amt );
    	}
    	
    	scin.close();
		sca.close();
		sc.close(); 
    	
    	    	   	
    }
}
