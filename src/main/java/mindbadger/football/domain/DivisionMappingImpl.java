package mindbadger.football.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "division_mapping")
@IdClass(MappingId.class)
public class DivisionMappingImpl implements DivisionMapping, Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "dialect")
	private String dialect;

	@Id
	@Column(name = "source_id")
	private Integer sourceId;

	@Id
	@Column(name = "fra_id")
	private Integer fraId;

	public DivisionMappingImpl () {
	}
	
	public DivisionMappingImpl (String dialect, Integer sourceId, Integer fraId) {
		this.dialect = dialect;
		this.sourceId = sourceId;
		this.fraId = fraId;
	}
	
	@Override
	public String getDialect() {
		return this.dialect;
	}

	@Override
	public Integer getSourceId() {
		return this.sourceId;
	}

	@Override
	public void setDialect(String dialect) {
		this.dialect = dialect;
	}

	@Override
	public void setSourceId(Integer sourceId) {
		this.sourceId = sourceId;
	}

	@Override
	public Integer getFraId() {
		return this.fraId;
	}

	@Override
	public void setFraId(Integer fraId) {
		this.fraId = fraId;
	}
}
