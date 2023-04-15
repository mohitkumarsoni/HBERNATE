package com.Git.gitHubHibernate;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
	@OneToMany(mappedBy = "question",fetch = FetchType.EAGER)
	private List<Answer> list;
	
	/*
	 * Lazy Loading:

Delay the loading of data until it is actually needed
Used with associations between entities
Associated data is not loaded from the database until it is accessed in code
Can be an efficient way to work with large data sets
Eager Loading:

Load data immediately, even if it is not needed yet
Used when you know that associated data will be needed soon
Avoids the overhead of additional database queries
Can improve performance in some cases

In summary, lazy loading is a way to save resources by loading data only when it is needed, while eager loading is a way to optimize performance by loading data immediately, even if it is not yet needed. Both techniques have their own advantages and can be used together to achieve the best performance for your application.
	 */
	
	
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
