package TRMS.P1.pojo;

public class UploadFile {
	
	private static int UploadFileCount;
	private int updateFileId;
	private String name;
	private String content;
	
	
	public UploadFile(String name, String content) {
		super();
		UploadFile.UploadFileCount++;
		this.updateFileId = UploadFile.UploadFileCount;
		this.name = name;
		this.content = content;
	}

	public UploadFile() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the uploadFileCount
	 */
	public static int getUploadFileCount() {
		return UploadFileCount;
	}

	/**
	 * @param uploadFileCount the uploadFileCount to set
	 */
	public static void setUploadFileCount(int uploadFileCount) {
		UploadFileCount = uploadFileCount;
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

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "UploadFile [updateFileId=" + updateFileId + ", name=" + name + ", content=" + content + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		UploadFile other = (UploadFile) obj;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (updateFileId != other.updateFileId)
			return false;
		return true;
	}
	

}
