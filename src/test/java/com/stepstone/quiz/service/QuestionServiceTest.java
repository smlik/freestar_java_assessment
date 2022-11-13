package com.stepstone.quiz.service;

import com.stepstone.quiz.repository.QuestionRepository;
import com.stepstone.quiz.repository.QuestionRepositoryImpl;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

/**
 * Tests for Question Service
 */
public class QuestionServiceTest {

    @Test
    public void getAll_shouldReturnQuestions(){
        // given
        final var mockQuestionRepository = mock(QuestionRepository.class);
        final var questionService = new QuestionServiceImpl(mockQuestionRepository);

        // when
        final var questions = questionService.getAll();

        // then
        assertThat(questions, is(notNullValue()));
    }
    
    @Test
    public void getAllByCategory_shouldReturnQuestions(){
        // given
        final var mockQuestionRepository = mock(QuestionRepository.class);
        final var questionService = new QuestionServiceImpl(mockQuestionRepository);

        // when
        final var questions = questionService.getAllByCategory("Geography");

        // then
        assertThat(questions, is(notNullValue()));
    }
    
    @Test
    public void validateAnswerOfQuestion_shouldValidateAnswer_true(){
        // given
        final var mockQuestionRepository = new QuestionRepositoryImpl();
        final var questionService = new QuestionServiceImpl(mockQuestionRepository);

        // when
        final var answerStatus = questionService.validateAnswerOfQuestion("What is the capital of Cuba?","abc");

        // then
        assertTrue(answerStatus);
    }
    
    @Test
    public void validateAnswerOfQuestion_shouldValidateAnswer_false(){
        // given
        final var mockQuestionRepository = new QuestionRepositoryImpl();
        final var questionService = new QuestionServiceImpl(mockQuestionRepository);

        // when
        final var answerStatus = questionService.validateAnswerOfQuestion("What is the capital of Cuba?","nothing");

        // then
        assertFalse(answerStatus);
    }
    
    @Test
    public void validateAnswerOfQuestion_shouldThrowException(){
        // given
        final var mockQuestionRepository = mock(QuestionRepository.class);
        final var questionService = new QuestionServiceImpl(mockQuestionRepository);

        // when
        final var exception = assertThrows(RuntimeException.class ,() ->
                questionService.validateAnswerOfQuestion("What is the capital of Cuba?","nothing"));

        // then
        String expectedMessage = "Question not Found";
        String actualMessage = exception.getMessage();
    
        assertTrue(actualMessage.contains(expectedMessage));
    }
}
