package TRMS.P1.daoInterface;

import java.util.List;

import TRMS.P1.pojo.Grade;

public interface GradeDao {
	
	public Grade readGrade(int gradeId);

	public List<Grade> readAllGrades();

}
