package com.stepstone.quiz.service;

import java.util.List;

/**
 *  Question Service Interface
 */
public interface QuestionService {
    List<String> getAll();
	
	List<String> getAllByCategory( String category );
	
	Boolean validateAnswerOfQuestion( String question, String answer );
}
