package com.instantmoney.JpaDemo;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

public class TestBalance {
	
BigDecimal initB = new BigDecimal("100"); 

BigDecimal topup = new BigDecimal ("200"); 

BigDecimal result = new BigDecimal ("300"); 

BigDecimal withdraw =  new BigDecimal ("200");

BigDecimal result2 = new BigDecimal ("100"); 

BigDecimal withdraw2 = new BigDecimal ("400");

int id = 1; 

Balance tb = new Balance(id, initB);

String error; 

@Test
public void TestTopUp() 
{
	tb.Topup(topup);
	assertEquals("The new balance expected ", result, initB);
	
}

public void TestWithdraw()
{
	tb.setBalance(result);
	tb.withdraw(withdraw);
	assertEquals("The new balance after withdraw ", result2, result);
}

public String TestWithdraw2()
{
	tb.setBalance(result);
	tb.withdraw(withdraw2);
	assertEquals("The message after withdraw ", error, withdraw2);
	return error;
}

}
