package com.instantmoney.JpaDemo;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

public class TestBalance {
	
Balance tb = new Balance();

BigDecimal initB = new BigDecimal("100"); 

BigDecimal topup = new BigDecimal ("200"); 

BigDecimal result = new BigDecimal ("300"); 

BigDecimal withdraw =  new BigDecimal ("200");

BigDecimal result2 = new BigDecimal ("100"); 

BigDecimal withdraw2 = new BigDecimal ("400");

String error; 

@Test
public void TestTopUp() 
{
	int id = 1; 
	tb.setIdsender(id);
	tb.setBalance(initB);
	assertEquals(result, tb.Topup(id, topup));
	
}

public void TestWithdraw()
{
	int id =1;
	tb.setIdsender(id);
	tb.setBalance(result);
	assertEquals(result2, tb.withdraw(id, withdraw)); 
}

public String TestWithdraw2()
{
	int id =1;	
	tb.setIdsender(id);
	tb.setBalance(result);
	assertEquals(error, tb.withdraw(id, withdraw2));
	return error;
}

}
