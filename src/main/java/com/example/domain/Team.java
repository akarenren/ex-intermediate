package com.example.domain;

/**
 * team用ドメイン.
 * 
 * @author ren.akase
 *
 */
public class Team {
	
	/** ID*/
	private Integer id;
	/** 所属リーグ*/
	private String leagueNmae;
	/** チーム名*/
	private String teamName;
	/** 本拠値*/
	private String headquarters;
	/** 設立日*/
	private String inauguration;
	/** 歴史*/
	private String history;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLeagueNmae() {
		return leagueNmae;
	}
	public void setLeagueNmae(String leagueNmae) {
		this.leagueNmae = leagueNmae;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public String getHeadquarters() {
		return headquarters;
	}
	public void setHeadquarters(String headquarters) {
		this.headquarters = headquarters;
	}
	public String getInauguration() {
		return inauguration;
	}
	public void setInauguration(String inauguration) {
		this.inauguration = inauguration;
	}
	public String getHistory() {
		return history;
	}
	public void setHistory(String history) {
		this.history = history;
	}
	@Override
	public String toString() {
		return "Team [id=" + id + ", leagueNmae=" + leagueNmae + ", teamName=" + teamName + ", headquarters="
				+ headquarters + ", inauguration=" + inauguration + ", history=" + history + "]";
	}
	
	
	

}
