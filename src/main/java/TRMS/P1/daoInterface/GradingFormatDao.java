package TRMS.P1.daoInterface;

import java.util.List;

import TRMS.P1.pojo.GradingFormat;

public interface GradingFormatDao {

	public GradingFormat readGradingFormat(int gradeFormatId);
	
	public List<GradingFormat> readAllGradingFormats();
	
}
