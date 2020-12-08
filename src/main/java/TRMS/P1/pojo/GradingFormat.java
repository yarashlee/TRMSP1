package TRMS.P1.pojo;

public class GradingFormat {
	
	private int gradeFormatId;
	private String gradeFormat;
	
	
	public GradingFormat(int gradeFormatId, String gradeFormat) {
		super();
		this.gradeFormatId = gradeFormatId;
		this.gradeFormat = gradeFormat;
	}


	public GradingFormat() {
		super();
		// TODO Auto-generated constructor stub
	}


	/**
	 * @return the gradeFormatId
	 */
	public int getGradeFormatId() {
		return gradeFormatId;
	}


	/**
	 * @param gradeFormatId the gradeFormatId to set
	 */
	public void setGradeFormatId(int gradeFormatId) {
		this.gradeFormatId = gradeFormatId;
	}


	/**
	 * @return the gradeFormat
	 */
	public String getGradeFormat() {
		return gradeFormat;
	}


	/**
	 * @param gradeFormat the gradeFormat to set
	 */
	public void setGradeFormat(String gradeFormat) {
		this.gradeFormat = gradeFormat;
	}


	@Override
	public String toString() {
		return "GradingFormat [gradeFormatId=" + gradeFormatId + ", gradeFormat=" + gradeFormat + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((gradeFormat == null) ? 0 : gradeFormat.hashCode());
		result = prime * result + gradeFormatId;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GradingFormat other = (GradingFormat) obj;
		if (gradeFormat == null) {
			if (other.gradeFormat != null)
				return false;
		} else if (!gradeFormat.equals(other.gradeFormat))
			return false;
		if (gradeFormatId != other.gradeFormatId)
			return false;
		return true;
	}
	

}
