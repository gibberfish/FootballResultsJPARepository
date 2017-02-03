package mindbadger;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

import mindbadger.footballresultsanalyser.domain.Season;
import mindbadger.footballresultsanalyser.domain.SeasonDivision;

@Entity
@Table(name = "season")
public class SeasonImpl implements Season, Serializable {
	private static final long serialVersionUID = 1L;

	private Integer seasonNumber;
	private List<SeasonDivision> divisionsInSeason = new ArrayList<SeasonDivision> ();
	
	public SeasonImpl () {}
	
	public SeasonImpl (Integer seasonNumber) {
		this.seasonNumber = seasonNumber;
	}
	
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@Basic(optional = false)
	@GeneratedValue(strategy=GenerationType.IDENTITY, generator="IdOrGenerated")
	@GenericGenerator(name="IdOrGenerated", strategy="mindbadger.UseIdOrGenerate")
	@Column(name = "ssn_num")
	@Override
	public Integer getSeasonNumber() {
		return this.seasonNumber;
	}

	@Override
	@OneToMany(mappedBy = "season", targetEntity=SeasonDivisionImpl.class, cascade=CascadeType.ALL, orphanRemoval=true)
	public List<SeasonDivision> getDivisionsInSeason() {
		return this.divisionsInSeason;
	}
	
	@Override
	public void setSeasonNumber(Integer seasonNumber) {
		this.seasonNumber = seasonNumber;
	}

	@Override
	public void setDivisionsInSeason(List<SeasonDivision> divisionsInSeason) {
		this.divisionsInSeason = divisionsInSeason;
	}
	
}
