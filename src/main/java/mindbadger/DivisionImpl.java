package mindbadger;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

import mindbadger.footballresultsanalyser.domain.Division;
import mindbadger.footballresultsanalyser.domain.SeasonDivision;

@Entity
@Table(name = "division")
public class DivisionImpl implements Division, Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	private String name;
	//private Set<SeasonDivision> seasonDivisions; 
	
	protected DivisionImpl () {
	}
	
	public DivisionImpl (String id, String name) {
		this.id = id; // This is not in publisher, as it's auto-generated
		this.name = name;
	}
	
	@Override
	@Id
	//The Publisher has @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "div_id")
	public String getDivisionId() {
		return id;
	}
	
	//@OneToMany(mappedBy = "division", targetEntity=SeasonDivisionImpl.class)
//	@OneToMany(targetEntity=SeasonDivisionImpl.class)
//	@JoinColumn(name="div_id", referencedColumnName="div_id")
//	public Set<SeasonDivision> getSeasonDivisions() {
//		return this.seasonDivisions;
//	}

	@Override
	@Column(name = "div_name")
	public String getDivisionName() {
		return name;
	}

	@Override
	public void setDivisionId(String id) {
		this.id = id;
	}

	@Override
	public void setDivisionName(String name) {
		this.name = name;
	}

//	public void setSeasonDivisions(Set<SeasonDivision> seasonDivisions) {
//		this.seasonDivisions = seasonDivisions;
//	}
}
