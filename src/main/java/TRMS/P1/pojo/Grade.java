package TRMS.P1.pojo;

public class Grade {
	
	private int gradeId;
	private String gradeLetter;
	private double minPercentage;
	private double maxPercentage;
	private String passFail;
	
	
	public Grade(int gradeId, String gradeLetter, double minPercentage, double maxPercentage, String passFail) {
		super();
		this.gradeId = gradeId;
		this.gradeLetter = gradeLetter;
		this.minPercentage = minPercentage;
		this.maxPercentage = maxPercentage;
		this.passFail = passFail;
	}
	

	public Grade() {
		super();
		// TODO Auto-generated constructor stub
	}


	/**
	 * @return the gradeId
	 */
	public int getGradeId() {
		return gradeId;
	}


	/**
	 * @param gradeId the gradeId to set
	 */
	public void setGradeId(int gradeId) {
		this.gradeId = gradeId;
	}


	/**
	 * @return the gradeLetter
	 */
	public String getGradeLetter() {
		return gradeLetter;
	}


	/**
	 * @param gradeLetter the gradeLetter to set
	 */
	public void setGradeLetter(String gradeLetter) {
		this.gradeLetter = gradeLetter;
	}


	/**
	 * @return the minPercentage
	 */
	public double getMinPercentage() {
		return minPercentage;
	}


	/**
	 * @param minPercentage the minPercentage to set
	 */
	public void setMinPercentage(double minPercentage) {
		this.minPercentage = minPercentage;
	}


	/**
	 * @return the maxPercentage
	 */
	public double getMaxPercentage() {
		return maxPercentage;
	}


	/**
	 * @param maxPercentage the maxPercentage to set
	 */
	public void setMaxPercentage(double maxPercentage) {
		this.maxPercentage = maxPercentage;
	}


	/**
	 * @return the passFail
	 */
	public String getPassFail() {
		return passFail;
	}


	/**
	 * @param passFail the passFail to set
	 */
	public void setPassFail(String passFail) {
		this.passFail = passFail;
	}


	@Override
	public String toString() {
		return "Grade [gradeId=" + gradeId + ", gradeLetter=" + gradeLetter + ", minPercentage=" + minPercentage
				+ ", maxPercentage=" + maxPercentage + ", passFail=" + passFail + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + gradeId;
		result = prime * result + ((gradeLetter == null) ? 0 : gradeLetter.hashCode());
		long temp;
		temp = Double.doubleToLongBits(maxPercentage);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(minPercentage);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((passFail == null) ? 0 : passFail.hashCode());
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
		Grade other = (Grade) obj;
		if (gradeId != other.gradeId)
			return false;
		if (gradeLetter == null) {
			if (other.gradeLetter != null)
				return false;
		} else if (!gradeLetter.equals(other.gradeLetter))
			return false;
		if (Double.doubleToLongBits(maxPercentage) != Double.doubleToLongBits(other.maxPercentage))
			return false;
		if (Double.doubleToLongBits(minPercentage) != Double.doubleToLongBits(other.minPercentage))
			return false;
		if (passFail == null) {
			if (other.passFail != null)
				return false;
		} else if (!passFail.equals(other.passFail))
			return false;
		return true;
	}
	

}
