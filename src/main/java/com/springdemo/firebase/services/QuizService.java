package com.springdemo.firebase.services;

import java.util.List;

import com.springdemo.firebase.dto.SaveUpdateDto;
import com.springdemo.firebase.dto.QuizDto;
import com.springdemo.firebase.entity.Quiz;

public interface QuizService {
	SaveUpdateDto addQuizDetails(Quiz addQuiz);
	
	List<QuizDto> retrieveQuiz(String collectionName);
	
	List<QuizDto> retrieveQuizPagination(String collectionName, String lastDocId, Integer count);
	
	//fetching single quiz object by ID
	QuizDto retrieveSingleQuiz(String collectionName, String quizId);
	
	//updating existing quiz
	SaveUpdateDto updateQuiz(QuizDto quizObj);
}
