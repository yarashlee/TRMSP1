package TRMS.P1.pojo;

public class Reimbursement {
	
	private static int reimbursementCount;
	private int reimbursementId;
	private int employeeId;
	private int eventId;
	private String dateSubmition;
	private String employeeCancellation;
	private String justification;
	private double amountRequested;
	private double adjustedAmount;
	private String directorSupervisorApprovalDate;
	private String departmentHeadApprovalDate;
	private String benCoApprovalDate;
	private int reimbursementStatusId;
	private String notes;
	private int updateFileId;
	
	
		public Reimbursement(int employeeId, int eventId, String dateSubmition, String employeeCancellation,
			String justification, double amountRequested, double adjustedAmount, String directorSupervisorApprovalDate,
			String departmentHeadApprovalDate, String benCoApprovalDate, int reimbursementStatusId, String notes,
			int updateFileId) {
		super();
		Reimbursement.reimbursementCount++;
		this.reimbursementId = Reimbursement.reimbursementCount;
		this.employeeId = employeeId;
		this.eventId = eventId;
		this.dateSubmition = dateSubmition;
		this.employeeCancellation = employeeCancellation;
		this.justification = justification;
		this.amountRequested = amountRequested;
		this.adjustedAmount = adjustedAmount;
		this.directorSupervisorApprovalDate = directorSupervisorApprovalDate;
		this.departmentHeadApprovalDate = departmentHeadApprovalDate;
		this.benCoApprovalDate = benCoApprovalDate;
		this.reimbursementStatusId = reimbursementStatusId;
		this.notes = notes;
		this.updateFileId = updateFileId;
	}


	public Reimbursement(int employeeId, int eventId, String justification, double amountRequested, double adjustedAmount) {
		super();
		this.employeeId = employeeId;
		this.eventId = eventId;
		this.justification = justification;
		this.amountRequested = amountRequested;
		this.adjustedAmount = adjustedAmount;
	}
	
	
	public Reimbursement(String departmentHeadApprovalDate, String notes) {
		super();
		this.departmentHeadApprovalDate = departmentHeadApprovalDate;
		this.notes = notes;
	}
	


	public Reimbursement(String departmentHeadApprovalDate, String benCoApprovalDate, int reimbursementStatusId,
			String notes) {
		super();
		this.departmentHeadApprovalDate = departmentHeadApprovalDate;
		this.benCoApprovalDate = benCoApprovalDate;
		this.reimbursementStatusId = reimbursementStatusId;
		this.notes = notes;
	}


	public Reimbursement(double adjustedAmount) {
		super();
		this.adjustedAmount = adjustedAmount;
	}


	public Reimbursement(String employeeCancellation) {
		super();
		this.employeeCancellation = employeeCancellation;
	}


	public Reimbursement() {
		super();
		// TODO Auto-generated constructor stub
	}


	/**
	 * @return the reimbursementCount
	 */
	public static int getReimbursementCount() {
		return reimbursementCount;
	}


	/**
	 * @param reimbursementCount the reimbursementCount to set
	 */
	public static void setReimbursementCount(int reimbursementCount) {
		Reimbursement.reimbursementCount = reimbursementCount;
	}


	/**
	 * @return the reimbursementId
	 */
	public int getReimbursementId() {
		return reimbursementId;
	}


	/**
	 * @param reimbursementId the reimbursementId to set
	 */
	public void setReimbursementId(int reimbursementId) {
		this.reimbursementId = reimbursementId;
	}


	/**
	 * @return the employeeId
	 */
	public int getEmployeeId() {
		return employeeId;
	}


	/**
	 * @param employeeId the employeeId to set
	 */
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}


	/**
	 * @return the eventId
	 */
	public int getEventId() {
		return eventId;
	}


	/**
	 * @param eventId the eventId to set
	 */
	public void setEventId(int eventId) {
		this.eventId = eventId;
	}


	/**
	 * @return the dateSubmition
	 */
	public String getDateSubmition() {
		return dateSubmition;
	}


	/**
	 * @param dateSubmition the dateSubmition to set
	 */
	public void setDateSubmition(String dateSubmition) {
		this.dateSubmition = dateSubmition;
	}


	/**
	 * @return the employeeCancellation
	 */
	public String getEmployeeCancellation() {
		return employeeCancellation;
	}


	/**
	 * @param employeeCancellation the employeeCancellation to set
	 */
	public void setEmployeeCancellation(String employeeCancellation) {
		this.employeeCancellation = employeeCancellation;
	}


	/**
	 * @return the justification
	 */
	public String getJustification() {
		return justification;
	}


	/**
	 * @param justification the justification to set
	 */
	public void setJustification(String justification) {
		this.justification = justification;
	}


	/**
	 * @return the amountRequested
	 */
	public double getAmountRequested() {
		return amountRequested;
	}


	/**
	 * @param amountRequested the amountRequested to set
	 */
	public void setAmountRequested(double amountRequested) {
		this.amountRequested = amountRequested;
	}


	/**
	 * @return the adjustedAmount
	 */
	public double getAdjustedAmount() {
		return adjustedAmount;
	}


	/**
	 * @param adjustedAmount the adjustedAmount to set
	 */
	public void setAdjustedAmount(double adjustedAmount) {
		this.adjustedAmount = adjustedAmount;
	}


	/**
	 * @return the directorSupervisorApprovalDate
	 */
	public String getDirectorSupervisorApprovalDate() {
		return directorSupervisorApprovalDate;
	}


	/**
	 * @param directorSupervisorApprovalDate the directorSupervisorApprovalDate to set
	 */
	public void setDirectorSupervisorApprovalDate(String directorSupervisorApprovalDate) {
		this.directorSupervisorApprovalDate = directorSupervisorApprovalDate;
	}


	/**
	 * @return the departmentHeadApprovalDate
	 */
	public String getDepartmentHeadApprovalDate() {
		return departmentHeadApprovalDate;
	}


	/**
	 * @param departmentHeadApprovalDate the departmentHeadApprovalDate to set
	 */
	public void setDepartmentHeadApprovalDate(String departmentHeadApprovalDate) {
		this.departmentHeadApprovalDate = departmentHeadApprovalDate;
	}


	/**
	 * @return the benCoApprovalDate
	 */
	public String getBenCoApprovalDate() {
		return benCoApprovalDate;
	}


	/**
	 * @param benCoApprovalDate the benCoApprovalDate to set
	 */
	public void setBenCoApprovalDate(String benCoApprovalDate) {
		this.benCoApprovalDate = benCoApprovalDate;
	}


	/**
	 * @return the reimbursementStatusId
	 */
	public int getReimbursementStatusId() {
		return reimbursementStatusId;
	}


	/**
	 * @param reimbursementStatusId the reimbursementStatusId to set
	 */
	public void setReimbursementStatusId(int reimbursementStatusId) {
		this.reimbursementStatusId = reimbursementStatusId;
	}


	/**
	 * @return the notes
	 */
	public String getNotes() {
		return notes;
	}


	/**
	 * @param notes the notes to set
	 */
	public void setNotes(String notes) {
		this.notes = notes;
	}


	/**
	 * @return the updateFileId
	 */
	public int getUpdateFileId() {
		return updateFileId;
	}


	/**
	 * @param updateFileId the updateFileId to set
	 */
	public void setUpdateFileId(int updateFileId) {
		this.updateFileId = updateFileId;
	}


	@Override
	public String toString() {
		return "Reimbursement [reimbursementId=" + reimbursementId + ", employeeId=" + employeeId + ", eventId="
				+ eventId + ", dateSubmition=" + dateSubmition + ", employeeCancellation=" + employeeCancellation
				+ ", justification=" + justification + ", amountRequested=" + amountRequested + ", adjustedAmount="
				+ adjustedAmount + ", directorSupervisorApprovalDate=" + directorSupervisorApprovalDate
				+ ", departmentHeadApprovalDate=" + departmentHeadApprovalDate + ", benCoApprovalDate="
				+ benCoApprovalDate + ", reimbursementStatusId=" + reimbursementStatusId + ", notes=" + notes
				+ ", updateFileId=" + updateFileId + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(adjustedAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(amountRequested);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((benCoApprovalDate == null) ? 0 : benCoApprovalDate.hashCode());
		result = prime * result + ((dateSubmition == null) ? 0 : dateSubmition.hashCode());
		result = prime * result + ((departmentHeadApprovalDate == null) ? 0 : departmentHeadApprovalDate.hashCode());
		result = prime * result
				+ ((directorSupervisorApprovalDate == null) ? 0 : directorSupervisorApprovalDate.hashCode());
		result = prime * result + ((employeeCancellation == null) ? 0 : employeeCancellation.hashCode());
		result = prime * result + employeeId;
		result = prime * result + eventId;
		result = prime * result + ((justification == null) ? 0 : justification.hashCode());
		result = prime * result + ((notes == null) ? 0 : notes.hashCode());
		result = prime * result + reimbursementId;
		result = prime * result + reimbursementStatusId;
		result = prime * result + updateFileId;
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
		Reimbursement other = (Reimbursement) obj;
		if (Double.doubleToLongBits(adjustedAmount) != Double.doubleToLongBits(other.adjustedAmount))
			return false;
		if (Double.doubleToLongBits(amountRequested) != Double.doubleToLongBits(other.amountRequested))
			return false;
		if (benCoApprovalDate == null) {
			if (other.benCoApprovalDate != null)
				return false;
		} else if (!benCoApprovalDate.equals(other.benCoApprovalDate))
			return false;
		if (dateSubmition == null) {
			if (other.dateSubmition != null)
				return false;
		} else if (!dateSubmition.equals(other.dateSubmition))
			return false;
		if (departmentHeadApprovalDate == null) {
			if (other.departmentHeadApprovalDate != null)
				return false;
		} else if (!departmentHeadApprovalDate.equals(other.departmentHeadApprovalDate))
			return false;
		if (directorSupervisorApprovalDate == null) {
			if (other.directorSupervisorApprovalDate != null)
				return false;
		} else if (!directorSupervisorApprovalDate.equals(other.directorSupervisorApprovalDate))
			return false;
		if (employeeCancellation == null) {
			if (other.employeeCancellation != null)
				return false;
		} else if (!employeeCancellation.equals(other.employeeCancellation))
			return false;
		if (employeeId != other.employeeId)
			return false;
		if (eventId != other.eventId)
			return false;
		if (justification == null) {
			if (other.justification != null)
				return false;
		} else if (!justification.equals(other.justification))
			return false;
		if (notes == null) {
			if (other.notes != null)
				return false;
		} else if (!notes.equals(other.notes))
			return false;
		if (reimbursementId != other.reimbursementId)
			return false;
		if (reimbursementStatusId != other.reimbursementStatusId)
			return false;
		if (updateFileId != other.updateFileId)
			return false;
		return true;
	}


	

}
