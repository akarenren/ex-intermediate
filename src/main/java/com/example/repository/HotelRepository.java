package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.domain.Hotel;

/**
 * hotelを操作するリポジトリ
 * 
 * @author ren.akase
 *
 */
@Repository
public class HotelRepository {

	/**
	 * Hotelオブジェクトを生成するローマッパー.
	 */
	private static final RowMapper<Hotel> HOTEL_ROW_MAPPER = new BeanPropertyRowMapper<>(Hotel.class);
	
	
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	
	/**
	 * hotel一覧を取得
	 * 
	 * @return　全ホテル
	 */
	public List<Hotel> findAll() {
		String sql = "SELECT id, area_name, hotel_name, address, nearest_station, price, parking FROM hotels;";
		List<Hotel> hotelList = template.query(sql, HOTEL_ROW_MAPPER);
		
		return hotelList;
	}
	
	/**
	 * 入力された値段以下のホテルを取得.
	 * 
	 * @param inputPrice 入力された価格
	 * @return　inputPrice以下の値段のホテル
	 */
	public List<Hotel> findByPrice(Integer inputPrice) {
		String sql = "SELECT id, area_name, hotel_name, address, nearest_station, price, parking FROM hotels WHERE price <= inputPrice;";
		List<Hotel> narrowHotelList = template.query(sql, HOTEL_ROW_MAPPER);
		
		return narrowHotelList;
	}
	
	
	
	
}
