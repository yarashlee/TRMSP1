package TRMS.P1.daoInterface;

import java.io.FileNotFoundException;
import java.util.List;

import TRMS.P1.pojo.UploadFile;

public interface UploadFileDao {
	
	public void createUploadFile(UploadFile uploadFile) throws FileNotFoundException;

	public UploadFileDao readUploadFile(int uploadFileId);

	public List<UploadFileDao> readAllUploadFile();

	public int updateUploadFile(int uploadFileId, UploadFile uploadFile);

	public int deleteUploadFile(int uploadFileId);

}
