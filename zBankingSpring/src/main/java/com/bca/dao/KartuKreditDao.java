package com.bca.dao;

import java.util.List;

import com.bca.model.Tagihan;
import com.bca.model.Transaksi;

public interface KartuKreditDao {
	public int bayarTagihan(String uname,int jumlahbayar);
	public Tagihan getTagihan(String username);
	public List<Transaksi> getTransaksi(String username, int bulanKurang);
}
