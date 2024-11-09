package com.springdemo.firebase.entity;

public class FileUpload {
	private String fileName;
    private String fileUrl;
    
    
    
	public FileUpload() {
		super();
	}
	public FileUpload(String fileName, String fileUrl) {
		super();
		this.fileName = fileName;
		this.fileUrl = fileUrl;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileUrl() {
		return fileUrl;
	}
	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}

}
