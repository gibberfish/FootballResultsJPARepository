package mindbadger.football.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.*;

import mindbadger.footballresultsanalyser.domain.Season;
import mindbadger.footballresultsanalyser.domain.SeasonDivision;

@Entity
@Table(name = "season")
public class SeasonImpl implements Season, Serializable {
	private static final long serialVersionUID = 1L;
	
	public SeasonImpl () {
		this.seasonDivisions = new HashSet<SeasonDivision> ();
	}
	
	public SeasonImpl (Integer seasonNumber) {
		this.seasonNumber = seasonNumber;
		this.seasonDivisions = new HashSet<SeasonDivision> ();
	}

	@Id
	@Column(name = "ssn_num")
	private Integer seasonNumber;

	@OneToMany(mappedBy = "season", targetEntity=SeasonDivisionImpl.class, fetch = FetchType.EAGER, cascade=CascadeType.DETACH)
	private Set<SeasonDivision> seasonDivisions; 
	
	@Override
	public Integer getSeasonNumber() {
		return this.seasonNumber;
	}

	@Override
	public Set<SeasonDivision> getSeasonDivisions() {
		return this.seasonDivisions;
	}
	
	@Override
	public void setSeasonNumber(Integer seasonNumber) {
		this.seasonNumber = seasonNumber;
	}

	@Override
	public void setSeasonDivisions(Set<SeasonDivision> seasonDivisions) {
		this.seasonDivisions = seasonDivisions;
	}

	@Override
	public int hashCode() {
		return Objects.hash(seasonNumber);
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof SeasonImpl)) return false;
			
		SeasonImpl seasonImplToCompare = (SeasonImpl) obj;
		
		return (seasonNumber.equals(seasonImplToCompare.getSeasonNumber()));
	}
	
	private String convertSeasonDivisionsToString () {
		StringBuffer sb = new StringBuffer();
		for (SeasonDivision seasonDivision : seasonDivisions) {
			sb.append(seasonDivision.getDivision().toString());
		}
		return sb.toString();
	}

	@Override
	public String toString() {
		return "Season["+seasonNumber+"]"+convertSeasonDivisionsToString();
	}
}

