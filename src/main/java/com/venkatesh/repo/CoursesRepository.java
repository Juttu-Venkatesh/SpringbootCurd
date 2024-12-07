package com.venkatesh.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.venkatesh.entity.Courses;

public interface CoursesRepository extends JpaRepository<Courses, Integer> {

}
