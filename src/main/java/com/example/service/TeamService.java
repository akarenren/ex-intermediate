package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.Team;
import com.example.repository.TeamRepository;

/**
 * チーム情報を操作するサービス.
 * 
 * @author ren.akase
 *
 */
@Service
public class TeamService {

	@Autowired
	private TeamRepository teamRepository;
	
	/**
	 * 全チームを取得.
	 * 
	 * @return 全チーム
	 */
	public List<Team> showList() {
		List<Team> teamList = teamRepository.findAll();
		return teamList;
	}
	
	/**
	 * 従業員情報を取得.
	 * 
	 * @param id:ID
	 * @return 従業員情報
	 */
	public Team showDetail(Integer id) {
		Team team = teamRepository.load(id);
		return team;
	}
}
