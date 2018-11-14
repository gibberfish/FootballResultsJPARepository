package mindbadger.football.domain;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;

import javax.persistence.*;

import mindbadger.football.domain.Division;
import mindbadger.football.domain.Fixture;
import mindbadger.football.domain.Season;
import mindbadger.football.domain.Team;

@Entity
@Table(name = "fixture")
public class FixtureImpl implements Fixture, Serializable {
	private static final long serialVersionUID = 832866330147762650L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "fixture_id")
	private String fixtureId;

	@Temporal(TemporalType.DATE)
	@Column(name = "fixture_date")
	private Calendar fixtureDate;
	
	@ManyToOne(fetch = FetchType.LAZY, targetEntity=TeamImpl.class)
	@JoinColumn(name = "home_team_id", referencedColumnName="team_id")
	private Team homeTeam;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity=TeamImpl.class)
	@JoinColumn(name = "away_team_id", referencedColumnName="team_id")
	private Team awayTeam;

	@JoinColumns({
			@JoinColumn(name="ssn_num", referencedColumnName="ssn_num"),
			@JoinColumn(name="div_id", referencedColumnName="div_id")
	})
	@ManyToOne(targetEntity=SeasonDivisionImpl.class)//, cascade=CascadeType.DETACH)
	private SeasonDivision seasonDivision;

	@Column(name = "home_goals")
	private Integer homeGoals;

	@Column(name = "away_goals")
	private Integer awayGoals;

	@Override
	public String getFixtureId() {
		return this.fixtureId;
	}

	@Override
	public void setFixtureId(String fixtureId) {
		this.fixtureId = fixtureId;
	}

	@Override
	public void setSeasonDivision(SeasonDivision seasonDivision) {
		this.seasonDivision = seasonDivision;
	}

	@Override
	public SeasonDivision getSeasonDivision() {
		return this.seasonDivision;
	}

	@Override
	public Team getHomeTeam() {
		return this.homeTeam;
	}

	@Override
	public void setHomeTeam(Team homeTeam) {
		this.homeTeam = homeTeam;
	}

	@Override
	public Team getAwayTeam() {
		return this.awayTeam;
	}

	@Override
	public void setAwayTeam(Team awayTeam) {
		this.awayTeam = awayTeam;
	}

	@Override
	public Calendar getFixtureDate() {
		return this.fixtureDate;
	}

	@Override
	public void setFixtureDate(Calendar fixtureDate) {
		this.fixtureDate = fixtureDate;
	}

	@Override
	public Integer getHomeGoals() {
		return this.homeGoals;
	}

	@Override
	public void setHomeGoals(Integer homeGoals) {
		this.homeGoals = homeGoals;
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
	public int hashCode() {
		return Objects.hash(fixtureId);
	}

	@Override
	public String toString() {
		Integer ssnNum = (seasonDivision != null & seasonDivision.getSeason() != null ?
				seasonDivision.getSeason().getSeasonNumber() : null);
		String divId = (seasonDivision != null & seasonDivision.getDivision() != null ?
				seasonDivision.getDivision().getDivisionId() : "");
		String hmTeam = (homeTeam == null ? "" : homeTeam.getTeamId());
		String awTeam = (awayTeam == null ? "" : awayTeam.getTeamId());
		return "Fixture[ssn:"+ssnNum+",div:"+divId+",hmTm:"+hmTeam+",awTm:"+awTeam+"]";
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof FixtureImpl)) return false;
		
		FixtureImpl fixtureImplToCompare = (FixtureImpl) obj;
		
		return (toString().equals(fixtureImplToCompare.toString()));
	}

}
