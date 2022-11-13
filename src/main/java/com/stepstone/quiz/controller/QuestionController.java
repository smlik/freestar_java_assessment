package com.stepstone.quiz.controller;

import com.stepstone.quiz.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

/**
 * Question Controller class
 */
@RestController
public class QuestionController {

    private final QuestionService questionService;
    
    @Autowired
    public QuestionController(QuestionService questionService){
        this.questionService = questionService;
    }

    @GetMapping("/questions")
    public List<String> getAll(){
        return questionService.getAll();
    }
    
    @GetMapping("/questions/by-category/{category}")
    public ResponseEntity<List<String>> getAllByCategory( @PathVariable String category ) {
        return ResponseEntity.ok(questionService.getAllByCategory(category));
    }
    
    @GetMapping("/questions/validate-answer")
    public ResponseEntity<Boolean> validateAnswer( @RequestParam("q") String question, @RequestParam("aoq") String answer ) {
        return ResponseEntity.ok(questionService.validateAnswerOfQuestion(question,answer));
    }
}
