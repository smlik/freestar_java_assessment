package com.stepstone.quiz.repository;

import com.stepstone.quiz.model.Question;

import java.util.List;
import java.util.Optional;

/**
 * Question Repository Interface
 */
public interface QuestionRepository {
    List<String> findAll();
    
    List<String> findAllByCategory( String category );
    
    Optional<Question> findByQuestion( String question);
}
