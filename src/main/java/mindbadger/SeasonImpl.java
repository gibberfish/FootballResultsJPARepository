package mindbadger;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import mindbadger.footballresultsanalyser.domain.Season;
import mindbadger.footballresultsanalyser.domain.SeasonDivision;

@Entity
@Table(name = "season")
public class SeasonImpl implements Season, Serializable {
	private static final long serialVersionUID = 1L;

	private Integer seasonNumber;
	private Set<SeasonDivision> seasonDivisions; 
	
	public SeasonImpl () {}
	
	public SeasonImpl (Integer seasonNumber) {
		this.seasonNumber = seasonNumber;
		this.seasonDivisions = new HashSet<SeasonDivision> ();
	}
	
	@Id
	@Column(name = "ssn_num")
	@Override
	public Integer getSeasonNumber() {
		return this.seasonNumber;
	}

	@Override
	@OneToMany(mappedBy = "season", targetEntity=SeasonDivisionImpl.class, cascade=CascadeType.ALL, orphanRemoval=true)
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
	
}
