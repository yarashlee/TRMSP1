package TRMS.P1.pojo;

public class ReimbursementStatus {
	
	private int reimbursementStatusId;
	private String status;
	
	
	
	public ReimbursementStatus(int reimbursementStatusId, String status) {
		super();
		this.reimbursementStatusId = reimbursementStatusId;
		this.status = status;
	}


	public ReimbursementStatus() {
		super();
		// TODO Auto-generated constructor stub
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
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}


	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}


	@Override
	public String toString() {
		return "ReimbursementStatus [reimbursementStatusId=" + reimbursementStatusId + ", status=" + status + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + reimbursementStatusId;
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		ReimbursementStatus other = (ReimbursementStatus) obj;
		if (reimbursementStatusId != other.reimbursementStatusId)
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}


}
