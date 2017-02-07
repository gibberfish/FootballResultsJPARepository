package mindbadger.football.model;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import mindbadger.footballresultsanalyser.domain.Division;
import mindbadger.footballresultsanalyser.domain.Fixture;
import mindbadger.footballresultsanalyser.domain.Season;
import mindbadger.footballresultsanalyser.domain.Team;

@Entity
@Table(name = "fixture")
public class FixtureImpl implements Fixture, Serializable {
	private static final long serialVersionUID = 1L;
	
	private Season season;
	private String fixtureId;
	private Calendar fixtureDate;
	private Team homeTeam;
	private Team awayTeam;
	private Division division;
	private Integer homeGoals;
	private Integer awayGoals;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "fixture_id")
	@Override
	public String getFixtureId() {
		return this.fixtureId;
	}
	
	@Override
	@ManyToOne(fetch = FetchType.LAZY, targetEntity=SeasonImpl.class)
	@JoinColumn(name = "ssn_num", referencedColumnName="ssn_num")
	public Season getSeason() {
		return this.season;
	}
	
	@Override
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fixture_date")
	public Calendar getFixtureDate() {
		return this.fixtureDate;
	}
	
	@Override
	@ManyToOne(fetch = FetchType.LAZY, targetEntity=TeamImpl.class)
	@JoinColumn(name = "home_team_id", referencedColumnName="team_id")
	public Team getHomeTeam() {
		return this.homeTeam;
	}
	
	@Override
	@ManyToOne(fetch = FetchType.LAZY, targetEntity=TeamImpl.class)
	@JoinColumn(name = "away_team_id", referencedColumnName="team_id")
	public Team getAwayTeam() {
		return this.awayTeam;
	}
	
	@Override
	@ManyToOne(fetch = FetchType.LAZY, targetEntity=DivisionImpl.class)
	@JoinColumn(name = "div_id", referencedColumnName="div_id")
	public Division getDivision() {
		return this.division;
	}
	
	@Override
	@Column(name = "home_goals")
	public Integer getHomeGoals() {
		return this.homeGoals;
	}
	
	@Override
	@Column(name = "away_goals")
	public Integer getAwayGoals() {
		return this.awayGoals;
	}

	@Override
	public void setAwayGoals(Integer awayGoals) {
		this.awayGoals = awayGoals;
	}

	@Override
	public void setAwayTeam(Team awayTeam) {
		this.awayTeam = awayTeam;
	}

	@Override
	public void setDivision(Division division) {
		this.division = division;
	}

	@Override
	public void setFixtureDate(Calendar fixtureDate) {
		this.fixtureDate = fixtureDate;
	}

	@Override
	public void setFixtureId(String fixtureId) {
		this.fixtureId = fixtureId;
	}

	@Override
	public void setHomeGoals(Integer homeGoals) {
		this.homeGoals = homeGoals;
	}

	@Override
	public void setHomeTeam(Team homeTeam) {
		this.homeTeam = homeTeam;
	}

	@Override
	public void setSeason(Season season) {
		this.season = season;
	}

}
