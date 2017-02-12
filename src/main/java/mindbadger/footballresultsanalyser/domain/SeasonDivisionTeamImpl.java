package mindbadger.footballresultsanalyser.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import mindbadger.footballresultsanalyser.domain.SeasonDivision;
import mindbadger.footballresultsanalyser.domain.SeasonDivisionTeam;
import mindbadger.footballresultsanalyser.domain.Team;

@Entity
@Table(name = "season_division_team")
@IdClass (SeasonDivisionTeamId.class)
public class SeasonDivisionTeamImpl implements SeasonDivisionTeam, Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@JoinColumns({
		@JoinColumn(name="ssn_num", referencedColumnName="ssn_num"),
		@JoinColumn(name="div_id", referencedColumnName="div_id")
	})
	@ManyToOne(targetEntity=SeasonDivisionImpl.class)//, cascade=CascadeType.DETACH)
	private SeasonDivision seasonDivision;
	
	@Id
	@JoinColumn(name = "team_id", referencedColumnName="team_id")
	@ManyToOne(fetch = FetchType.LAZY, targetEntity=TeamImpl.class)
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
