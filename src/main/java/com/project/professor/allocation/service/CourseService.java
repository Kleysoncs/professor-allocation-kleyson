package com.project.professor.allocation.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.professor.allocation.entity.Course;
import com.project.professor.allocation.repository.CourseRepository;

@Service
public class CourseService {

	private final CourseRepository courseRepository;

	public CourseService(CourseRepository courseRepository) {
		super();
		this.courseRepository = courseRepository;
	}

	public List<Course> findAll() {

		List<Course> courses = courseRepository.findAll();
		return courses;
	}

	public Course findById(Long id) {

		return courseRepository.findById(id).orElse(null);
	}

	public Course create(Course course) {

		course.setId(null);
		return saveInternal(course);

	}

	public Course update(Course course) {

		Long id = course.getId();
		if (id != null && courseRepository.existsById(id)) {

			return saveInternal(course);
		} else {

			return null;
		}
	}

	public Course saveInternal(Course course) {

		if (hasCollision(course)) {

			throw new RuntimeException("The course name already exists.");
		}

		else {

			return courseRepository.save(course);
		}
	}

	public void deleteById(Long id) {

		if (courseRepository.existsById(id)) {

			courseRepository.deleteById(id);

		}
	}

	public void deleteAll() {

		courseRepository.deleteAllInBatch();

	}

	private boolean hasCollision(Course newCourse) {

		boolean hasCollision = false;
		List<Course> currentCourses = findAll();

		for (Course currentCourse : currentCourses) {
			if (currentCourse.getName().equals(newCourse.getName())) {
				hasCollision = true;
				break;
			}
		}

		return hasCollision;
	}
}
