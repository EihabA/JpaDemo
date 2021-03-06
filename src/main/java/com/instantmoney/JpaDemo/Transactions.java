package com.instantmoney.JpaDemo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Transactions {

	@Id
	private int idtrans;
	private int idreceiver;
	private int idsender;
	private int idexchange;
	private BigDecimal amount; 
	private LocalDateTime timestamp;
	
	public Transactions(int whoToReceive, BigDecimal amountToSend) {
		
		this.idreceiver = whoToReceive; 
		this.amount = amountToSend; 
	}
	
	public Transactions ()
	{
		
	}
	
	public int getIdtrans() {
		return idtrans;
	}
	public void setIdtrans(int idtrans) {
		this.idtrans = idtrans;
	}
	public int getIdreceiver() {
		return idreceiver;
	}
	public void setIdreceiver(int idreceiver) {
		this.idreceiver = idreceiver;
	}
	public int getIdsender() {
		return idsender;
	}
	public void setIdsender(int idsender) {
		this.idsender = idsender;
	}
	public int getIdexchange() {
		return idexchange;
	}
	public void setIdexchange(int idexchange) {
		this.idexchange = idexchange;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public LocalDateTime getTimestamp() {
		return LocalDateTime.now();
	}
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	@Override
	public String toString() {
		return "Transactions [idtrans=" + idtrans + ", idreceiver=" + idreceiver + ", idsender=" + idsender
				+ ", idexchange=" + idexchange + ", amount=" + amount + ", timestamp=" + timestamp + "]";
	}
	
	
}
