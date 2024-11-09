package com.springdemo.firebase.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.springdemo.firebase.dto.FileDownloadDto;
import com.springdemo.firebase.entity.FileUpload;
import com.springdemo.firebase.services.FileUploadService;

@RestController
@RequestMapping(path = "api/quiz/")
public class FileUploadController {
	@Autowired
	FileUploadService fileUploadService;
	

	@PostMapping("file/upload")
	public ResponseEntity<FileUpload> uploadFile(@RequestParam("file") MultipartFile file) {
		try {
			FileUpload fileUrl = fileUploadService.uploadDocument(file);
			return new ResponseEntity<FileUpload>(fileUrl, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<FileUpload>(new FileUpload(null, null), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("file/download")
	public ResponseEntity<byte[]> fileDownload(@RequestParam String filePath){
		
		FileDownloadDto fileDownloadDto = this.fileUploadService.downloadDocument(filePath);
        return new ResponseEntity<>(fileDownloadDto.getContent(), fileDownloadDto.getHttpHeaders(), HttpStatus.OK);
	}

}
