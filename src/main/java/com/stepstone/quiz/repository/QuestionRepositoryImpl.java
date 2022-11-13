package com.stepstone.quiz.repository;

import com.stepstone.quiz.AppConstants;
import com.stepstone.quiz.model.Question;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Static Question Repository implementation
 */
@Repository
public class QuestionRepositoryImpl implements QuestionRepository {
    public List<String> findAll() {
        return AppConstants.QUESTIONS
                .stream()
                .map(Question::getQuestion)
                .collect(Collectors.toList());
    }
    
    @Override
    public List<String> findAllByCategory( String category) {
        return AppConstants.QUESTIONS
                .stream()
                .filter(q-> q.isOfCategory(category))
                .map(Question::getQuestion)
                .collect(Collectors.toList());
    }
    
    @Override
    public Optional<Question> findByQuestion( String question ) {
        return AppConstants.QUESTIONS
                .stream()
                .filter(q -> q.isOfQuestion(question))
                .findAny();
    }
}
