package mindbadger.football.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;

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
	private static final long serialVersionUID = 832866330147762650L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "fixture_id")
	private String fixtureId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fixture_date")
	private Calendar fixtureDate;
	
	@ManyToOne(fetch = FetchType.LAZY, targetEntity=TeamImpl.class)
	@JoinColumn(name = "home_team_id", referencedColumnName="team_id")
	private Team homeTeam;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity=TeamImpl.class)
	@JoinColumn(name = "away_team_id", referencedColumnName="team_id")
	private Team awayTeam;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity=SeasonImpl.class)
	@JoinColumn(name = "ssn_num", referencedColumnName="ssn_num")
	private Season season;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity=DivisionImpl.class)
	@JoinColumn(name = "div_id", referencedColumnName="div_id")
	private Division division;

	@Column(name = "home_goals")
	private Integer homeGoals;

	@Column(name = "away_goals")
	private Integer awayGoals;
	
	@Override
	public String getFixtureId() {
		return this.fixtureId;
	}
	
	@Override
	public Season getSeason() {
		return this.season;
	}
	
	@Override
	public Calendar getFixtureDate() {
		return this.fixtureDate;
	}
	
	@Override
	public Team getHomeTeam() {
		return this.homeTeam;
	}
	
	@Override
	public Team getAwayTeam() {
		return this.awayTeam;
	}
	
	@Override
	public Division getDivision() {
		return this.division;
	}
	
	@Override
	public Integer getHomeGoals() {
		return this.homeGoals;
	}
	
	@Override
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

	@Override
	public int hashCode() {
		return Objects.hash(fixtureId);
	}

	@Override
	public String toString() {
		return "Fixture[ssn:"+season+",hmTm:"+homeTeam+"awTm:"+awayTeam+"]";
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof DivisionImpl)) return false;
		
		DivisionImpl divisionImplToCompare = (DivisionImpl) obj;
		
		return (toString().equals(divisionImplToCompare.toString()));
	}

}
