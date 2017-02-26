package mindbadger.football.domain;

import java.io.Serializable;
import java.util.Objects;

public class MappingId implements Serializable {
	private static final long serialVersionUID = 8013910648038828574L;

	private String dialect;
	private Integer sourceId;
	private Integer fraId;

	@Override
	public int hashCode() {
		return Objects.hash(dialect, sourceId, fraId);	
	}
	
	@Override
	public boolean equals(Object obj) {
		if (! (obj instanceof MappingId)) return false;
		MappingId trackedDivsionId = (MappingId) obj;
		
		boolean sourceIdEqual = (sourceId == trackedDivsionId.getSourceId());
		boolean fraIdEqual = (fraId == trackedDivsionId.getFraId());
		boolean dialectEqual = dialect.equals(trackedDivsionId.getDialect());
		
		return (sourceIdEqual && dialectEqual & fraIdEqual);
	}
	
	public Integer getSourceId() {
		return sourceId;
	}

	public Integer getFraId() {
		return fraId;
	}

	public String getDialect() {
		return dialect;
	}

	public void setSourceId(Integer sourceId) {
		this.sourceId = sourceId;
	}

	public void setFraId(Integer fraId) {
		this.fraId = fraId;
	}
	
	public void setDialect(String dialect) {
		this.dialect = dialect;
	}
}

