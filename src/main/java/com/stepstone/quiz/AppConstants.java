package com.stepstone.quiz;

import com.stepstone.quiz.model.Question;

import java.util.List;

public class AppConstants {
	
	public static final List<Question> QUESTIONS = List.of(
			new Question("What is the capital of Cuba?","Geography","Havana"),
			new Question("What is the capital of France?","Geography","Paris"),
			new Question("What is the capital of Poland?","Geography","Warsaw"),
			new Question("What is the capital of Germany?","Geography","Berlin")
	);
}
