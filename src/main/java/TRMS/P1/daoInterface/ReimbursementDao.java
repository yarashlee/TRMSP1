package TRMS.P1.daoInterface;

import java.util.List;

import TRMS.P1.pojo.Reimbursement;

public interface ReimbursementDao {
	
	public void createReimbursement(Reimbursement reimbursement);

	public Reimbursement readReimbursement(int reimbursementId);

	public List<Reimbursement> readReimbursementByEmployeeId(int employeeId);

	public List<Reimbursement> readAllReimbursements();

	public List<Reimbursement> readAllReimbsByReportTo(int reportsTo);

	public int updateReimbursementDepHead(int reimbursementId, Reimbursement reimbursement);
	
	public int updateReimbursementDirSup(int reimbursementId, Reimbursement reimbursement);

	public int updateReimbursementBenCo(int reimbursementId, Reimbursement reimbursement);

	public int updateReimbursement(int reimbursementid, Reimbursement reimbursement);
	
	public int updateReimbursementCancellation(int reimbursementId, Reimbursement reimbursement);
	
	public int updateAdjustedAmount(int reimbursementId, Reimbursement reimbursement);

	public int deleteReimbursement(int reimbursementId);

}
