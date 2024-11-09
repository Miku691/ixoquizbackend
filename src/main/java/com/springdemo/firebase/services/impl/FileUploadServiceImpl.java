package com.springdemo.firebase.services.impl;

import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.google.cloud.storage.Blob;
import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.Storage;
import com.springdemo.firebase.dto.FileDownloadDto;
import com.springdemo.firebase.entity.FileUpload;
import com.springdemo.firebase.services.FileUploadService;
import com.springdemo.firebase.utility.ApplicationConstants;

@Service
public class FileUploadServiceImpl implements FileUploadService {
	
	@Autowired
	private Storage storage;
	
	@Override
	public FileUpload uploadDocument(MultipartFile file) throws IOException {
		
		String fileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
		
		String bucketName = ApplicationConstants.FIREBASE_STORAGE_BOCKET;
        Bucket bucket = storage.get(bucketName);
        
        Blob blob = bucket.create(fileName, file.getInputStream());
        String fileUrl = blob.getMediaLink();
        
		return new FileUpload(fileName, fileUrl);
	}

	@Override
	public FileDownloadDto downloadDocument(String filePath) {
		
		HttpHeaders headers = new HttpHeaders();
		
		Blob blob = storage.get(ApplicationConstants.FIREBASE_STORAGE_BOCKET, filePath);
		
		byte[] content = blob.getContent();
		
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + blob.getName() + "\"");
        headers.add(HttpHeaders.CONTENT_TYPE, blob.getContentType());
        
        return new FileDownloadDto(content, headers);
	}

}
