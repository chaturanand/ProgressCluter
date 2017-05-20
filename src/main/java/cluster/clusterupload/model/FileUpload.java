package cluster.clusterupload.model;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class FileUpload {
	private CommonsMultipartFile[] files;

	public CommonsMultipartFile[] getFiles() {
		return files;
	}

	public void setFiles(CommonsMultipartFile[] files) {
		this.files = files;
	}
	
	
}
