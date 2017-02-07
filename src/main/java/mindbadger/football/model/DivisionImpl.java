package mindbadger.football.model;

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
	private static final long serialVersionUID = -391877074618292394L;

	protected DivisionImpl () {
	}
	
	public DivisionImpl (String id, String name) {
		this.id = id; // This is not in publisher, as it's auto-generated
		this.name = name;
	}

	@Id
	@Column(name = "div_id")
	private String id;

	@Column(name = "div_name")
	private String name;
	
	@Override
	public String getDivisionId() {
		return id;
	}
	
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
		return "Division["+id+":"+name+"]";
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
}
