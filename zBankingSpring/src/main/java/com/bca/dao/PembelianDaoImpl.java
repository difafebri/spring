package com.bca.dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.bca.model.Pembelian;

public class PembelianDaoImpl implements PembelianDao{

	private JdbcTemplate template;

	public void setTemplate(DataSource ds) {
		this.template = new JdbcTemplate(ds);
	}
	
	@Override
	public int save(Pembelian buy) {
		String sql="insert into pembelian (provider,nohp,nominal,token,username) values(?,?,?,?,?)";  
	    return template.update(sql,new Object[] {buy.getProvider(), buy.getNohp(), buy.getNominal(), buy.getToken(), buy.getUsername()});
	}

}
