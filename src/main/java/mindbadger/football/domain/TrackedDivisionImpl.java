package mindbadger.football.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "tracked_division")
@IdClass(TrackedDivisionId.class)
public class TrackedDivisionImpl implements TrackedDivision, Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "dialect")
	private String dialect;

	@Id
	@Column(name = "source_id")
	private Integer sourceId;

	public TrackedDivisionImpl () {
	}
	
	public TrackedDivisionImpl (String dialect, Integer sourceId) {
		this.dialect = dialect;
		this.sourceId = sourceId;
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
}
