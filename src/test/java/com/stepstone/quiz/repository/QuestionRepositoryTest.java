package com.stepstone.quiz.repository;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Tests for Question Repository
 */

public class QuestionRepositoryTest {

    @Test
    public void findAll_shouldReturnQuestions(){
        // given
        final var questionRepository = new QuestionRepositoryImpl();

        // when
        final var questions = questionRepository.findAll();

        // then
        assertThat(questions, is(notNullValue()));
        assertThat(questions, is(hasSize(4)));
    }
    
    @Test
    public void findByCategory_shouldReturnQuestions(){
        // given
        final var questionRepository = new QuestionRepositoryImpl();

        // when
        final var questions = questionRepository.findAllByCategory("Geography");

        // then
        assertThat(questions, is(notNullValue()));
        assertThat(questions, is(hasSize(4)));
    }
    
    @Test
    public void findByQuestion_shouldReturnQuestion(){
        // given
        final var questionRepository = new QuestionRepositoryImpl();

        // when
        final var question = questionRepository.findByQuestion("What is the capital of Cuba?");

        // then
        assertTrue(question.isPresent());
    }
    
    @Test
    public void findByQuestion_shouldNotReturnQuestion(){
        // given
        final var questionRepository = new QuestionRepositoryImpl();

        // when
        final var question = questionRepository.findByQuestion("What is the capital?");

        // then
        assertFalse(question.isPresent());
    }
}
