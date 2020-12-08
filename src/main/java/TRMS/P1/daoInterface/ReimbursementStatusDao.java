package TRMS.P1.daoInterface;

import java.util.List;

import TRMS.P1.pojo.ReimbursementStatus;

public interface ReimbursementStatusDao {
	
	public ReimbursementStatus readReimbursementStatus(int reimbursementStatusId);

	public List<ReimbursementStatus> readAllReimbursementStatuses();

}
