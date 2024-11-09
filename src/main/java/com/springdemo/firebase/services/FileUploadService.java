package com.springdemo.firebase.services;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.springdemo.firebase.dto.FileDownloadDto;
import com.springdemo.firebase.entity.FileUpload;

public interface FileUploadService {
	FileUpload uploadDocument(MultipartFile file) throws IOException;
	
	FileDownloadDto downloadDocument(String filePath);
}
