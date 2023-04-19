package com.mapping;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Question {
	@Id
	@Column(name = "Question_Id")
	private int questionId;
	@Column(name = "Question")
	private String question;
	@OneToMany (mappedBy = "question",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<Answer> list;
	
	//cascade will save/delete all (answers/values) from the database which is connected with question
	
	
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	
	public List<Answer> getList() {
		return list;
	}
	public void setList(List<Answer> list) {
		this.list = list;
	}
	
	public Question(int questionId, String question, List<Answer> list) {
		super();
		this.questionId = questionId;
		this.question = question;
		this.list = list;
	}
	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
