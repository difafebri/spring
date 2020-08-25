package com.bca.dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.bca.model.Pembayaran;

public class PembayaranDaoImpl implements PembayaranDao{

	private JdbcTemplate template;

	public void setTemplate(DataSource ds) {
		this.template = new JdbcTemplate(ds);
	}
	
	@Override
	public int save(Pembayaran pay) {
		String sql="insert into pembayaran (jenisProvider,noHp,nominal,username) values(?,?,?,?)";  
	    return template.update(sql,new Object[] {pay.getJenisProvider(), pay.getNoHp(), pay.getNominal(), pay.getUsername()});
	}

}
