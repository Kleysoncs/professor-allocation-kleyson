package com.project.professor.allocation.repository;

import com.project.professor.allocation.entity.Professor;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestPropertySource;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
@TestPropertySource(locations = "classpath:application.properties")
public class ProfessorRepositoryTest {

	@Autowired
    ProfessorRepository professorRepository;

    @Test
    public void findAll() {
        // Act
        List<Professor> professors = professorRepository.findAll();

        // Print
        professors.forEach(System.out::println);
        
    }

    @Test
    public void findById() {
        // Arrange
    	Long id = 1L;

        // Act
        Professor professor = professorRepository.findById(id).orElse(null);

        // Print
        System.out.println(professor);
        
    }
    
    @Test
    public void findByNameLikeIgnoreCase() {
        // Arrange
    	String name = "Jose";

        // Act
        List<Professor> professors = professorRepository.findByNameContainingIgnoreCase(name);

        // Print
        professors.forEach(System.out::println);
        
    }

    @Test
    public void findByDepartmentId() {
        // Arrange
        Long id = 2L;

        // Act
        List<Professor> professors = professorRepository.findByDepartmentId(id);

        // Print
        professors.forEach(System.out::println);
        
    }

    @Test
    public void save_create() {
        // Arrange
        Professor professor = new Professor();
        professor.setId(null);
        professor.setName("Eduardo Moura");
        professor.setCpf("78945612336");
        professor.setDepartmentId(2L);

        // Act
        professor = professorRepository.save(professor);

        // Print
        System.out.println(professor);
        
    }

    @Test
    public void save_update() {
    	// Arrange
        Professor professor = new Professor();
        professor.setId(4L);
        professor.setName("Carlos Meireles");
        professor.setCpf("14725836978");
        professor.setDepartmentId(4L);

        // Act
        professor = professorRepository.save(professor);

        // Print
        System.out.println(professor);
        
    }

    @Test
    public void deleteById() {
        // Arrange
        Long id = 2L;

        // Act
        professorRepository.deleteById(id);
        
    }

    @Test
    public void deleteAll() {
        // Act
    	professorRepository.deleteAllInBatch();
        
    }
}
