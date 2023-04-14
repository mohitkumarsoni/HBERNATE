package com.Git.gitHubHibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Certificate {
	@Column(name = "Course")
	private String course;
	@Column(name = "Course_Duration")
	private String Duration;

	
	
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getDuration() {
		return Duration;
	}
	public void setDuration(String duration) {
		Duration = duration;
	}
	
	
	

	public Certificate(String course, String duration) {
		super();
		this.course = course;
		Duration = duration;
	}

	public Certificate() {
		super();
		// TODO Auto-generated constructor stub
	}

}
