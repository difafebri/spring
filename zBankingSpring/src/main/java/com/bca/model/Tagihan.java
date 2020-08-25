package com.bca.model;

import java.sql.Date;

public class Tagihan {
	private String username;
	private int total_tagihan;
	private Date jatuh_tempo;
	private int paid;
	private Date createdDate;
	private Date updatedDate;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getTotal_tagihan() {
		return total_tagihan;
	}
	public void setTotal_tagihan(int total_tagihan) {
		this.total_tagihan = total_tagihan;
	}
	public Date getJatuh_tempo() {
		return jatuh_tempo;
	}
	public void setJatuh_tempo(Date jatuh_tempo) {
		this.jatuh_tempo = jatuh_tempo;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	public int getPaid() {
		return paid;
	}
	public void setPaid(int paid) {
		this.paid = paid;
	}	
}
