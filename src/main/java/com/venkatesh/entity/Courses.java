package com.venkatesh.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Courses {
	@Id
	@Column(name="COURSE_ID")
	private Integer courseId;
	@Column(name="COURSE_NAME")
	private String courseName;
	@Column(name="DEPARTMENT")
	private String department;
	@Column(name="CREDITS")
	private Integer credits;
}
