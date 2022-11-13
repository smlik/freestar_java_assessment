package com.stepstone.quiz.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Question {
	
	private String question;
	
	//Single Question may belong to multiple categories.
	//Then List<String> can be used.
	private String category;
	private String answer;
	
	
	/**
	 * This method checks whether parametrized category is equals to question's category or not.
	 * @param category to be verified with the object
	 * @return true if categories are same or false otherwise
	 */
	public boolean isOfCategory( String category ){
		return this.getCategory().equalsIgnoreCase(category);
	}
	
	
	/**
	 * This method checks whether parametrized question string is equals to object's question or not.
	 * @param question to be verified with the object
	 * @return true if question is same or false otherwise
	 */
	public boolean isOfQuestion( String question ){
		return this.getQuestion().equalsIgnoreCase(question);
	}
}
