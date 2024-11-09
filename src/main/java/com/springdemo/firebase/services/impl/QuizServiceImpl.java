package com.springdemo.firebase.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.Query;
import com.google.cloud.firestore.QuerySnapshot;
import com.springdemo.firebase.dto.QuizDto;
import com.springdemo.firebase.dto.SaveUpdateDto;
import com.springdemo.firebase.entity.Quiz;
import com.springdemo.firebase.services.QuizService;
import com.springdemo.firebase.utility.ApiResponseStatus;
import com.springdemo.firebase.utility.ApplicationConstants;
import com.springdemo.firebase.exceptions.ResourceNotFoundException;

@Service
public class QuizServiceImpl implements QuizService{

	@Autowired
	private Firestore firestore;
	
	@Autowired
    private ObjectMapper objectMapper;
	
	/*
	 * This will take the quiz object(addQuiz) and collection name.
	 * Inside this collection one new document will create and with document the quiz will save
	 * 
	 * docRef.getId() - will be the id of that document 
	 */
	@Override
	public SaveUpdateDto addQuizDetails(Quiz addQuiz) {
		DocumentReference docRef = firestore.collection(addQuiz.getCategory()).document();
		docRef.set(addQuiz);
		
		ApiResponseStatus apiRes = new ApiResponseStatus(ApplicationConstants.STATUS_SUCCESS
				, ApplicationConstants.ADD_QUIZ_SUCCESS_MSG);
		return new SaveUpdateDto(addQuiz.getCategory(), docRef.getId(), apiRes);
	}

	/*
	 * Retrieving each document data present in a collection and converting those into DTO class 
	 * 
	 * objectMapper.convertValue - this will convert a map into Java Class (if the class variables
	 * name and map key names matches)
	 */
	@Override
	public List<QuizDto> retrieveQuiz(String collectionName) {
		List<QuizDto> quizResDtoLst = new ArrayList<>();
		try {
			firestore.collection(collectionName).get().get().getDocuments()
			.stream().forEach(
					item -> {
						Quiz quizRes = objectMapper.convertValue(item.getData(), 
								Quiz.class);
						quizResDtoLst.add(new QuizDto(collectionName, item.getId(), quizRes));
					}
				);
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		return quizResDtoLst;
	}

	/*
	 * retrieveQuizPagination - here tried to achieve pagination like other database
	 * in firebase we do not have direct pagination system, but we can achieve with some modification
	 * we have limit(count) to get a specified numbers of documents
	 * 
	 * Now only we need to go batch by batch, so here we are taking first batch with a limit count,
	 * for next batch we are using the lastDocumentID of the first batch to get documents after the id
	 * startAfter - helping on this
	 */
	@Override
	public List<QuizDto> retrieveQuizPagination(String collectionName, String lastDocId, Integer count) {
		List<QuizDto> quizResDtoLst = new ArrayList<>();
		Query query = this.firestore.collection(collectionName).orderBy("question");
		
		try {
			int allDocCount = query.get().get().size();
			System.out.println(allDocCount);
			if(lastDocId != null && !lastDocId.isEmpty()) 
				query = query.startAfter(this.firestore.collection(collectionName).document(lastDocId).get().get());
			
			QuerySnapshot queryBatch = query.limit(count).get().get();
			queryBatch.getDocuments().stream().forEach(item -> {
				Quiz quizRes = objectMapper.convertValue(item.getData(), 
						Quiz.class);
				quizResDtoLst.add(new QuizDto(collectionName, item.getId(), quizRes));
			});
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		return quizResDtoLst;
	}

	@Override
	public QuizDto retrieveSingleQuiz(String collectionName, String quizId) {
		Quiz quiz = null;
		try {
			Map<String, Object> quizMap = this.firestore.collection(collectionName).
					document(quizId).get().get().
					getData();
			if(quizMap == null || quizMap.isEmpty())
				throw new ResourceNotFoundException("QuizId", quizId, ApplicationConstants.RESOURCE_NOT_FOUND_CAPTION);
			quiz = this.objectMapper.convertValue(quizMap, Quiz.class);
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		return new QuizDto(collectionName, quizId, quiz);
	}

	@Override
	public SaveUpdateDto updateQuiz(QuizDto quizObj) {
		String quizId = quizObj.getQuizId();
		String collectionName = quizObj.getCollectionName();
		Quiz updatedQuiz = quizObj.getQuiz();
		
		DocumentReference docRef = firestore.collection(collectionName).document(quizId);
		docRef.set(updatedQuiz);
		
		ApiResponseStatus apiRes = new ApiResponseStatus(ApplicationConstants.STATUS_SUCCESS
				, ApplicationConstants.UPDATE_QUIZ_SUCCESS_MSG);
		return new SaveUpdateDto(collectionName, quizId, apiRes);
	}
	
}
