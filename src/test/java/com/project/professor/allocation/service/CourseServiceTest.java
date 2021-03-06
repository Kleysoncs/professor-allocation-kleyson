package com.project.professor.allocation.service;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import com.project.professor.allocation.entity.Course;

@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")
public class CourseServiceTest {

	@Autowired
	CourseService courseService;

	@Test
	public void findAll() {

		List<Course> courses = courseService.findAll(null);

		courses.forEach(System.out::println);
	}
	
	 @Test
	    public void findAllByName() {
	        // Arrange
	        String name = "course";

	        // Act
	        List<Course> courses = courseService.findAll(name);

	        // Print
	        courses.forEach(System.out::println);
	    }

	@Test
	public void findById() {

		Long id = 1L;
		System.out.println(courseService.findById(id));

	}

	@Test
	public void save() {

		Course course = new Course();
		course.setId(null);
		course.setName("Física II");

		course = courseService.create(course);

		System.out.println(course);
	}

	@Test
	public void update() {

		Course course = new Course();
		course.setId(2L);
		course.setName("Física II");

		course = courseService.update(course);

		System.out.println(course);
	}

	@Test
	public void deleteById() {

		Long id = 1L;
		courseService.deleteById(id);

	}

	@Test
	public void deleteAll() {

		courseService.deleteAll();

	}

}
