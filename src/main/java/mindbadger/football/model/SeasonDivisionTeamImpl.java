package mindbadger.football.model;

import java.io.Serializable;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import mindbadger.footballresultsanalyser.domain.SeasonDivision;
import mindbadger.footballresultsanalyser.domain.SeasonDivisionTeam;
import mindbadger.footballresultsanalyser.domain.Team;

public class SeasonDivisionTeamImpl implements SeasonDivisionTeam, Serializable {
	private static final long serialVersionUID = 1L;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity=SeasonDivisionImpl.class)
	@JoinColumn(name = "team_id", referencedColumnName="team_id")
	private SeasonDivision seasonDivision;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity=TeamImpl.class)
	@JoinColumn(name = "team_id", referencedColumnName="team_id")
	private Team team;
	
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
