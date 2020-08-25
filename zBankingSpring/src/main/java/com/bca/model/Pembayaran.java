package com.bca.model;

public class Pembayaran {
	private String jenisProvider;
	private String noHp;
	private int nominal;
	private String username;
	
	public String getJenisProvider() {
		return jenisProvider;
	}
	public void setJenisProvider(String jenisProvider) {
		this.jenisProvider = jenisProvider;
	}
	public String getNoHp() {
		return noHp;
	}
	public void setNoHp(String noHp) {
		this.noHp = noHp;
	}
	public int getNominal() {
		return nominal;
	}
	public void setNominal(int nominal) {
		this.nominal = nominal;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
}
