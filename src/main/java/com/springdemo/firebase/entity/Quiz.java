package com.springdemo.firebase.entity;

public class Quiz {
	private String question;
	private QuizOptions quizOptions;
	private Integer correctAns;
	private String ansDescription;
	private String category;
	

	public Quiz() {
		super();
	}

	public Quiz(String question, QuizOptions quizOptions, Integer correctAns, String ansDescription, String category) {
		super();
		this.question = question;
		this.quizOptions = quizOptions;
		this.correctAns = correctAns;
		this.ansDescription = ansDescription;
		this.category = category;
	}
	
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public QuizOptions getQuizOptions() {
		return quizOptions;
	}
	public void setQuizOptions(QuizOptions quizOptions) {
		this.quizOptions = quizOptions;
	}
	public Integer getCorrectAns() {
		return correctAns;
	}
	public void setCorrectAns(Integer correctAns) {
		this.correctAns = correctAns;
	}
	public String getAnsDescription() {
		return ansDescription;
	}
	public void setAnsDescription(String ansDescription) {
		this.ansDescription = ansDescription;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
}
