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
	public String search(Integer price, Model model) {
		List<Hotel> hotelList;
		if(price == null) {
			hotelList = hotelService.showList();
		} else {
			hotelList = hotelService.showNarrowList(price);
		}
		
		model.addAttribute("hotelList", hotelList);
		
		return index(model);
	}
}
