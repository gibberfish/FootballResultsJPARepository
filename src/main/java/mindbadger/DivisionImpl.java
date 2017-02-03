package mindbadger;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import mindbadger.footballresultsanalyser.domain.Division;

@Entity
@Table(name = "division")
public class DivisionImpl implements Division, Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	private String name;
	
	protected DivisionImpl () {
	}
	
	public DivisionImpl (String id, String name) {
		this.id = id;
		this.name = name;
	}
	
	@Override
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@GeneratedValue(strategy=GenerationType.IDENTITY, generator="IdOrGenerated")
	@GenericGenerator(name="IdOrGenerated", strategy="mindbadger.UseIdOrGenerate")
	@Column(name = "div_id")
	public String getDivisionId() {
		return id;
	}

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

}
