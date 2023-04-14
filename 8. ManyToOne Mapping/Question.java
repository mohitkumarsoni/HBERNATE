package com.Git.gitHubHibernate;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Question {
	@Id
	@Column(name = "Question_Id")
	private int id;
	@Column(name = "Question")
	private String question;
	@OneToMany(mappedBy = "question")
	private List<Answer> list;
	
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	
	
	
	
	public Question(int id, String question, List<Answer> list) {
		super();
		this.id = id;
		this.question = question;
		this.list = list;
	}
	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
}
