package com.bca.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.bca.model.Tagihan;
import com.bca.model.Transaksi;

public class KartuKreditDaoImpl implements KartuKreditDao{
	
	private JdbcTemplate template;

	public void setTemplate(DataSource ds) {
		this.template = new JdbcTemplate(ds);
	}

	@Override
	public Tagihan getTagihan(String username) {
		String sql="select * from tagihan where username=? and MONTH(tanggalCetak) = MONTH(CURRENT_DATE)-1";
		List<Tagihan> listTagihan = template.query(sql, new Object[] {username}, new RowMapper<Tagihan>() {
					public Tagihan mapRow(ResultSet rs, int rowNum) throws SQLException {
						Tagihan tg = new Tagihan();
						tg.setUsername(rs.getString("username"));
						tg.setTotal_tagihan(rs.getInt("total_tagihan"));
						tg.setJatuh_tempo(rs.getDate("jatuh_tempo"));
						tg.setUpdatedDate(rs.getDate("tanggalCetak"));
						tg.setCreatedDate(rs.getDate("createdDate"));
						return tg;
					}
				});
		if (listTagihan.isEmpty()) {
			return null;
		} else { // list contains exactly 1 element
			return listTagihan.get(0);
		}
	}
	
	@Override
	public int bayarTagihan(String uname,int jumlahbayar) {
		Tagihan tgh = getTagihan(uname);
		int sisaBayar = tgh.getTotal_tagihan()-jumlahbayar;
		String sql="update tagihan set total_tagihan="+sisaBayar+ ", "
				+ "updatedDate = CURRENT_DATE where username='"+uname+"' and MONTH(tanggalCetak) = MONTH(CURRENT_DATE)-1";
		System.out.println("TEST INI DAH LEWAT");
	    return template.update(sql);	
	}

	@Override
	public List<Transaksi> getTransaksi(String username, int bulanKurang) {
		String sql= "select * from transaksi where username=? and MONTH(tanggalTransaksi) = MONTH(CURRENT_DATE)-"+bulanKurang+"";
		List<Transaksi> transList = template.query(sql, new Object[] {username}, new RowMapper<Transaksi>(){  
	        public Transaksi mapRow(ResultSet rs, int row) throws SQLException {  
	            Transaksi tr = new Transaksi();  
	            tr.setUsername(rs.getString("username"));
	            tr.setNamaMerchant(rs.getString("namaMerchant"));
	            tr.setNominalTransaksi(rs.getInt("nominalTransaksi"));
	            tr.setTanggalTransaksi(rs.getDate("tanggalTransaksi"));
	            return tr;  
	        }  
	    }); 
		if (transList.isEmpty()) {
			return null;
		} else {
			return transList;
		}
	}
}
