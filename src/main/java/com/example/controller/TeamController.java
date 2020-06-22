package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Team;
import com.example.service.TeamService;

/**
 * チーム情報を操作するコントローラ.
 * 
 * @author ren.akase
 *
 */
@Controller
@RequestMapping("")
public class TeamController {
	@Autowired
	private TeamService teamService;
	

	/**
	 * チーム一覧画面を表示.
	 * 
	 * @param model:モデル
	 * @return　チーム一覧画面
	 */
	@RequestMapping("/index")
	public String index(Model model) {
		List<Team> teamList = teamService.showList();
		model.addAttribute("teamList", teamList);
		return "index";
	}
	
	/**
	 * チーム詳細画面.
	 * 
	 * @param id:ID
	 * @param model:モデル
	 * @return　一覧画面
	 */
	@RequestMapping("detail")
	public String detail(Integer id, Model model) {
		Team team = teamService.showDetail(id);
		model.addAttribute("team", team);
		return "detail";
	}
}
