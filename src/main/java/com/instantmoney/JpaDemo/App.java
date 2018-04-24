package com.instantmoney.JpaDemo;

import java.math.BigDecimal;

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
    	  	
    	
    }
}
