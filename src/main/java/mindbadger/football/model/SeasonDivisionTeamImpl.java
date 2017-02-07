package mindbadger.football.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import mindbadger.footballresultsanalyser.domain.Division;
import mindbadger.footballresultsanalyser.domain.Season;
import mindbadger.footballresultsanalyser.domain.SeasonDivision;
import mindbadger.footballresultsanalyser.domain.SeasonDivisionTeam;
import mindbadger.footballresultsanalyser.domain.Team;

@Entity
@Table(name = "season_division_team")
@IdClass(SeasonDivisionTeamId.class)
public class SeasonDivisionTeamImpl implements SeasonDivisionTeam, Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="season")
	private Integer season;
	
	@Id
	@Column(name="division")
	private String division;

	@MapsId("seasonDivisionId")
	@ManyToOne(fetch = FetchType.LAZY, targetEntity=SeasonDivisionImpl.class, cascade=CascadeType.DETACH)
	@JoinColumns({
		@JoinColumn(name = "season", referencedColumnName="ssn_num"),
		@JoinColumn(name = "division", referencedColumnName="div_id")
	})
	private SeasonDivision seasonDivision;
	
	@Id
	@ManyToOne(fetch = FetchType.LAZY, targetEntity=TeamImpl.class)
	@JoinColumn(name = "team_id", referencedColumnName="team_id")
	private Team team;
	
//	@Id
//	@ManyToOne(fetch = FetchType.LAZY, targetEntity=SeasonImpl.class)
//	@JoinColumn(name = "ssn_num", referencedColumnName="ssn_num")
//	public Season getSeason () {
//		return this.seasonDivision.getSeason();
//	}
//
//	@Id
//	@ManyToOne(fetch = FetchType.LAZY, targetEntity=DivisionImpl.class)
//	@JoinColumn(name = "div_id", referencedColumnName="div_id")
//	public Division getDivision () {
//		return this.seasonDivision.getDivision();
//	}
//	
//	
//	public void setSeason(Season season) {
//		this.seasonDivision.setSeason(season);
//	}
//	
//	public void setDivision (Division division) {
//		this.seasonDivision.setDivision(division);
//	}
	
	@Override
	public SeasonDivision getSeasonDivision() {
		return this.seasonDivision;
	}

	@Override
	public Team getTeam() {
		return this.team;
	}

	@Override
	public void setSeasonDivision(SeasonDivision seasonDivision) {
		this.seasonDivision = seasonDivision;
	}

	@Override
	public void setTeam(Team team) {
		this.team = team;
	}
}
