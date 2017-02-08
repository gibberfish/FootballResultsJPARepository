package mindbadger.football.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;

//@Embeddable
public class SeasonDivisionTeamId implements Serializable {
	private static final long serialVersionUID = 7195048183491291063L;

//	@EmbeddedId
	private SeasonDivisionId seasonDivisionId;
	
//	@Column(name="teamId")
	private String teamId;

	public SeasonDivisionTeamId () {}
	
	public SeasonDivisionTeamId (SeasonDivisionId seasonDivisionId, String teamId) {
		this.teamId = teamId;
		this.seasonDivisionId = seasonDivisionId;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(seasonDivisionId, teamId);	
	}
	
	@Override
	public boolean equals(Object obj) {
		if (! (obj instanceof SeasonDivisionId)) return false;
		SeasonDivisionTeamId seasonDivisionTeamId = (SeasonDivisionTeamId) obj;
		
		boolean seasonDivisionEqual = seasonDivisionId.equals(seasonDivisionTeamId.getSeasonDivisionId());
		boolean teamEqual = teamId.equals(seasonDivisionTeamId.getTeamId());
		
		return (seasonDivisionEqual && teamEqual);
	}
	
	public SeasonDivisionId getSeasonDivisionId() {
		return seasonDivisionId;
	}
	
	public void setSeasonDivisionId(SeasonDivisionId seasonDivisionId) {
		this.seasonDivisionId = seasonDivisionId;
	}
	
	public String getTeamId() {
		return teamId;
	}

	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}
	

}
