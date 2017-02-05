package mindbadger;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import mindbadger.footballresultsanalyser.domain.Division;

@Entity
@Table(name = "division")
public class DivisionImpl implements Division, Serializable {

	private static final long serialVersionUID = 1L;

	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "div_id")
	private String id;

	@Column(name = "div_name")
	private String name;
//	private Set<SeasonDivision> seasonDivisions; 
	
	protected DivisionImpl () {
	}
	
	public DivisionImpl (String id, String name) {
		this.id = id; // This is not in publisher, as it's auto-generated
		this.name = name;
	}
	
	@Override
	public String getDivisionId() {
		return id;
	}
	
//	@OneToMany(mappedBy = "division", targetEntity=SeasonDivisionImpl.class)
//	public Set<SeasonDivision> getSeasonDivisions() {
//		return this.seasonDivisions;
//	}

	@Override
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

	@Override
	public String toString() {
		return "["+id+":"+name+"]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(toString());
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof DivisionImpl)) return false;
		
		DivisionImpl divisionImplToCompare = (DivisionImpl) obj;
		
		return (toString().equals(divisionImplToCompare.toString()));
	}

	
//	public void setSeasonDivisions(Set<SeasonDivision> seasonDivisions) {
//		this.seasonDivisions = seasonDivisions;
//	}
}
