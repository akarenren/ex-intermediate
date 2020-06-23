package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.Hotel;
import com.example.repository.HotelRepository;

/**
 * Hotelを操作するサービス
 * 
 * @author ren.akase
 *
 */
@Service
public class HotelService {

	@Autowired
	private HotelRepository hotelRepository;
	
	/**
	 * hotel一覧を取得.
	 * 
	 * @return hotel一覧
	 */
	public List<Hotel> showList() {
		List<Hotel> hotelList = hotelRepository.findAll();
		return hotelList;
	}
	
	/**
	 * 入力された価格以下のホテルを取得.
	 * 
	 * @param inputPrice 入力された価格
	 * @return　条件に一致するホテル
	 */
	public List<Hotel> showNarrowList(Integer inputPrice) {
		List<Hotel> narrowHotelList = hotelRepository.findByPrice(inputPrice);
		return narrowHotelList;
	}
}
