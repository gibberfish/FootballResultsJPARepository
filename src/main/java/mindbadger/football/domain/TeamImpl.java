package mindbadger.football.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import mindbadger.football.domain.Team;

@Entity
@Table(name = "team")
public class TeamImpl implements Team, Serializable {
	private static final long serialVersionUID = 1L;
	
	public TeamImpl () {
	}
	
	public TeamImpl (String id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public TeamImpl (String id, String name, String shortName) {
		this.id = id;
		this.name = name;
		this.shortName = shortName;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "team_id")
	private String id;

	@Column(name = "team_name")
	private String name;
	
	@Column(name = "team_short_name")
	private String shortName;

	@Override
	public String getTeamId() {
		return id;
	}

	@Override
	public String getTeamName() {
		return name;
	}

	@Override
	public String getTeamShortName() {
		return shortName;
	}

	@Override
	public void setTeamId(String id) {
		this.id = id;
	}

	@Override
	public void setTeamName(String name) {
		this.name = name;
	}

	@Override
	public void setTeamShortName(String shortName) {
		this.shortName = shortName;
	}

	@Override
	public String toString() {
		return "Team["+id+":"+name+"]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(toString());
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof TeamImpl)) return false;
		
		TeamImpl teamImplToCompare = (TeamImpl) obj;
		
		return (toString().equals(teamImplToCompare.toString()));
	}

}
