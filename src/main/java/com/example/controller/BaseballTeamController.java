package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class BaseballTeamController {

	@RequestMapping("/index")
	public String index() {
		return "index";
	}
	
	@RequestMapping("show")
	public String show() {
		return "show";
	}
}
