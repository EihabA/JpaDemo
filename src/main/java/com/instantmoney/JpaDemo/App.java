package com.instantmoney.JpaDemo;

import java.time.LocalDateTime;

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
    	
    	Transactions t = new Transactions(); 
    	
    	t.setIdtrans(9);
    	t.setIdsender(4);
    	t.setIdreceiver(4);
    	t.setIdexchange(2);
    	t.setAmount(85.0);
    	t.setTimestamp(LocalDateTime.now());
    
    	
       	EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
    	
    	EntityManager em = emf.createEntityManager();
    	
    	/*em.getTransaction().begin();
    	em.persist(s);
    	em.getTransaction().commit();
    	*/
       	em.getTransaction().begin();
    	em.persist(t);
    	em.getTransaction().commit();
    	
        //Sender sender = em.find(Sender.class,6);
        
      System.out.println(t.toString());
    	  	
    	
    }
}
