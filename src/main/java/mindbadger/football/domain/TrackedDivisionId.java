package mindbadger.football.domain;

import java.io.Serializable;
import java.util.Objects;

public class TrackedDivisionId implements Serializable {
	private static final long serialVersionUID = 8013910648038828574L;

	private String dialect;
	private Integer sourceId;

	@Override
	public int hashCode() {
		return Objects.hash(dialect, sourceId);	
	}
	
	@Override
	public boolean equals(Object obj) {
		if (! (obj instanceof TrackedDivisionId)) return false;
		TrackedDivisionId trackedDivsionId = (TrackedDivisionId) obj;
		
		boolean sourceIdEqual = (sourceId == trackedDivsionId.getSourceId());
		boolean dialectEqual = dialect.equals(trackedDivsionId.getDialect());
		
		return (sourceIdEqual && dialectEqual);
	}
	
	public Integer getSourceId() {
		return sourceId;
	}
	
	public String getDialect() {
		return dialect;
	}

	public void setSourceId(Integer sourceId) {
		this.sourceId = sourceId;
	}
	
	public void setDialect(String dialect) {
		this.dialect = dialect;
	}
}

