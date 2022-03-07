package com.project.professor.allocation.service;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import com.project.professor.allocation.entity.Professor;

@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")
public class ProfessorServiceTest {
	
	@Autowired
	ProfessorService professorService;
	
	@Test
	public void findAll() {
		
		List<Professor> professors = professorService.findAll(null);
		professors.forEach(System.out::println);
		
	}
	
	 @Test
	    public void findAllByName() {
	        // Arrange
	        String name = "professor";

	        // Act
	        List<Professor> professors = professorService.findAll(name);

	        // Print
	        professors.forEach(System.out::println);
	    }

	    @Test
	    public void findByDepartment() {
	        // Arrange
	        Long departmentId = 1L;

	        // Act
	        List<Professor> professors = professorService.findByDepartment(departmentId);

	        // Print
	        professors.forEach(System.out::println);
	    }
	
	@Test
	public void findById() {
		
		Long id = 1L;
		System.out.println(professorService.findById(id));
		
	}
	
	@Test
	public void save() {
		
		Professor professor = new Professor();
		professor.setId(null);
		professor.setName("Ricardo Almeida da Silva");
		professor.setCpf("55522288877");
		professor.setDepartmentId(3L);
		
		professor = professorService.create(professor);
		
		System.out.println(professor);
		
	}
	
	@Test
	public void update() {
		
		Professor professor = new Professor();
		professor.setId(1L);
		professor.setName("Ricardo Almeida da Silva");
		professor.setCpf("55522288877");
		professor.setDepartmentId(3L);
		
		professor = professorService.update(professor);
		
		System.out.println(professor);
		
	}
	
	@Test
	public void deleteById() {
		
		Long id = 1L;
		professorService.deleteById(id);
		
	}
	
	@Test
	public void deleteAll() {
		
		professorService.deleteAll();
		
	}

}
