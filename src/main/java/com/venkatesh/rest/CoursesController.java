package com.venkatesh.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.venkatesh.entity.Courses;
import com.venkatesh.repo.CoursesRepository;

@RestController
public class CoursesController {
	
	@Autowired
	private CoursesRepository coursesRepo;
	
	@PostMapping("/course")
	public ResponseEntity<Courses> addCourse(@RequestBody Courses course) {
		return new ResponseEntity<>(coursesRepo.save(course),HttpStatus.CREATED);
	}
	
	@GetMapping("/course")
	public ResponseEntity<List<Courses>> getCourses() {
		return new ResponseEntity<>(coursesRepo.findAll(),HttpStatus.OK);
	}
	@GetMapping("/course/{courseId}")
	public ResponseEntity<Courses> getCourse(@PathVariable Integer courseId) {
		Optional<Courses> course = coursesRepo.findById(courseId);
		if (course.isPresent()) {
			return new ResponseEntity<>(course.get(),HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@PostMapping("/course/{courseId}")
	public ResponseEntity<Courses> updateCourse(@PathVariable Integer courseId, 
			@RequestBody Courses course) {
		Optional<Courses>courses = coursesRepo.findById(courseId);
		if (courses.isPresent()) {
			courses.get().setCourseId(course.getCourseId());
			courses.get().setCourseName(course.getCourseName());
			courses.get().setDepartment(course.getDepartment());
			courses.get().setCredits(course.getCredits());
			return new ResponseEntity<>(coursesRepo.save(courses.get()),HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@DeleteMapping("/course/{courseId}")
	public ResponseEntity<Courses> deleteCourse(@PathVariable Integer courseId) {
		Optional <Courses>course = coursesRepo.findById(courseId);
		if (course.isPresent()) {
			coursesRepo.deleteById(courseId);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
}
