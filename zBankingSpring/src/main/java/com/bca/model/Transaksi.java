package com.bca.model;

import java.sql.Date;

public class Transaksi {
	private String namaMerchant;
	private String username;
	private Date tanggalTransaksi;
	private int nominalTransaksi;
	public String getNamaMerchant() {
		return namaMerchant;
	}
	public void setNamaMerchant(String namaMerchant) {
		this.namaMerchant = namaMerchant;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Date getTanggalTransaksi() {
		return tanggalTransaksi;
	}
	public void setTanggalTransaksi(Date tanggalTransaksi) {
		this.tanggalTransaksi = tanggalTransaksi;
	}
	public int getNominalTransaksi() {
		return nominalTransaksi;
	}
	public void setNominalTransaksi(int nominalTransaksi) {
		this.nominalTransaksi = nominalTransaksi;
	}
}
