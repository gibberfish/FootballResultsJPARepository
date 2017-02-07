package mindbadger.football.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import mindbadger.footballresultsanalyser.domain.Team;

@Entity
@Table(name = "team")
public class TeamImpl implements Team, Serializable {
	private static final long serialVersionUID = 1L;

	private String id;
	private String name;
	private String shortName;
	
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

	@Override
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "team_id")
	public String getTeamId() {
		return id;
	}

	@Override
	@Column(name = "team_name")
	public String getTeamName() {
		return name;
	}

	@Override
	@Column(name = "team_short_name")
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

}
