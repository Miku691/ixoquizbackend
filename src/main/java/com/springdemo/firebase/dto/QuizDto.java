package com.springdemo.firebase.dto;

import com.springdemo.firebase.entity.Quiz;

public class QuizDto {
	private String collectionName;
	private String quizId;
	private Quiz quiz;
	
	
	
	public QuizDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public QuizDto(String collectionName, String quizId, Quiz quiz) {
		super();
		this.collectionName = collectionName;
		this.quizId = quizId;
		this.quiz = quiz;
	}
	public String getQuizId() {
		return quizId;
	}
	public void setQuizId(String quizId) {
		this.quizId = quizId;
	}
	public Quiz getQuiz() {
		return quiz;
	}
	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}
	public String getCollectionName() {
		return collectionName;
	}
	public void setCollectionName(String collectionName) {
		this.collectionName = collectionName;
	}
	
}
