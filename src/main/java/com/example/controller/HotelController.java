package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Hotel;
import com.example.service.HotelService;

@Controller
@RequestMapping("/hotel")
public class HotelController {

	@Autowired
	private HotelService hotelService;
	
	/**
	 * ホテル検索入力画面表示.
	 * 
	 * @return ホテル検索入力画面
	 */
	@RequestMapping("")
	public String index(Model model) {
		
		return "hotel-index";
	}
	
	/**
	 * ホテル検索結果画面表示.
	 * 
	 * @param price:価格
	 * @param model:モデル
	 * @return　検索結果画面
	 */
	@RequestMapping("/search")
	public String search(String price, Model model) {
		List<Hotel> hotelList;
		
		if("".equals(price)) {
			hotelList = hotelService.showList();
		} else if(isNumber(price) == false){
			hotelList = hotelService.showList();
		} else {
			int changeprice = Integer.parseInt(price);
			hotelList = hotelService.showNarrowList(changeprice);
		}
		
		model.addAttribute("hotelList", hotelList);
		
		return index(model);
	}
	
	/**
	 * 入力値を数値か判定.
	 * 
	 * @param num：入力値
	 * @return　入力された値が数値ならtrueそれ以外はfalse
	 */
	public boolean isNumber(String price) {
	    try {
	        Integer.parseInt(price);
	        	return true;
	    } catch (NumberFormatException e) {
	        	return false;
	    }
	}
}
