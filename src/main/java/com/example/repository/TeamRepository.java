package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.Team;

/**
 * teamテーブルを操作するリポジトリ.
 * 
 * @author ren.akase
 *
 */
@Repository
public class TeamRepository {

	/**
	 * Teamオブジェクトを生成するローマッパー.
	 */
	public static final RowMapper<Team> TEAM_ROW_MAPPER = (rs, i) -> {
		Team team = new Team();
		team.setId(rs.getInt("id"));
		team.setLeagueNmae(rs.getString("league_name"));
		team.setTeamName(rs.getString("team_name"));
		team.setHeadquarters(rs.getString("headquarters"));
		team.setInauguration(rs.getString("inauguration"));
		team.setHistory(rs.getString("history"));
		return team;
	};
	
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	/**
	 * Team一覧を発足日順に取得.
	 * 
	 * @return　全チーム
	 */
	public List<Team> findAll() {
		String sql = "SELECT id, league_name, team_name, headquarters, inauguration FROM teams ORDER BY inauguration;";
		List<Team> teamList = template.query(sql, TEAM_ROW_MAPPER);
		
		return teamList;
	}
	
	/**
	 * 主キーからチームの情報を取得.
	 * 
	 * @param id:ID
	 * @return 検索されたチーム
	 */
	public Team load(Integer id) {
		String sql = "SELECT id, league_name, team_name, headquarters, inauguration FROM teams WHERE id = :id;";
		SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
		Team team = template.queryForObject(sql, param, TEAM_ROW_MAPPER);
		
		return team;
		
	}
}
