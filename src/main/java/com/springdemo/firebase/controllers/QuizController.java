package com.springdemo.firebase.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springdemo.firebase.dto.SaveUpdateDto;
import com.springdemo.firebase.dto.QuizDto;
import com.springdemo.firebase.entity.Quiz;
import com.springdemo.firebase.services.QuizService;


@RestController
@RequestMapping(path = "api/quiz/")
public class QuizController {

	@Autowired
	private QuizService quizService;
	
	@PostMapping("add")
	public ResponseEntity<SaveUpdateDto> addQuiz(
			@RequestBody Quiz addQuiz
			){
		SaveUpdateDto savedQuiz = quizService.addQuizDetails(addQuiz);
		return new ResponseEntity<SaveUpdateDto>(savedQuiz, HttpStatus.CREATED);
	}
	
	@GetMapping("collection/{collecName}")
	public ResponseEntity<List<QuizDto>> retrieveQuiz(@PathVariable String collecName){
		return new ResponseEntity<List<QuizDto>>(this.quizService.retrieveQuiz(collecName)
				, HttpStatus.OK);
	}
	
	@GetMapping("collection/{collecName}/pagination")
	public ResponseEntity<List<QuizDto>> retrieveQuizWithPagination(
			@PathVariable String collecName,
			@RequestParam(value = "lastDocId", required = false) String lastDocId,
			@RequestParam(value = "count") Integer count
			){
		return new ResponseEntity<List<QuizDto>>(this.quizService
				.retrieveQuizPagination(collecName, lastDocId, count)
				, HttpStatus.OK);
	}
	
	//get single quiz by quizID
	@GetMapping("{collectionName}/{quizId}")
	public ResponseEntity<QuizDto> getSingleQuiz(
			@PathVariable String collectionName,
			@PathVariable String quizId){
		return new ResponseEntity<QuizDto>(this.quizService.retrieveSingleQuiz(collectionName,quizId), HttpStatus.OK);
	}
	
	@PostMapping("update")
	public ResponseEntity<SaveUpdateDto> updateQuiz(@RequestBody QuizDto quizDto){
		return new ResponseEntity<SaveUpdateDto>(this.quizService.updateQuiz(quizDto),HttpStatus.OK);
	}
}
