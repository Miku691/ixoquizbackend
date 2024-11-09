package com.springdemo.firebase.dto;

import org.springframework.http.HttpHeaders;

public class FileDownloadDto {
	private byte[] content;
	private HttpHeaders httpHeaders;
	
	
	
	public FileDownloadDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FileDownloadDto(byte[] content, HttpHeaders httpHeaders) {
		super();
		this.content = content;
		this.httpHeaders = httpHeaders;
	}
	public byte[] getContent() {
		return content;
	}
	public void setContent(byte[] content) {
		this.content = content;
	}
	public HttpHeaders getHttpHeaders() {
		return httpHeaders;
	}
	public void setHttpHeaders(HttpHeaders httpHeaders) {
		this.httpHeaders = httpHeaders;
	}
	
	
}
