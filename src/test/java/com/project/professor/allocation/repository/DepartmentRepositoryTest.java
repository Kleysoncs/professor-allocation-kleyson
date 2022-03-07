package com.project.professor.allocation.repository;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestPropertySource;

import com.project.professor.allocation.entity.Department;

import java.util.List;


@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
@TestPropertySource(locations = "classpath:application.properties")
public class DepartmentRepositoryTest {

	 @Autowired
	    DepartmentRepository departmentRepository;

	    @Test
	    public void findAll() {
	        // Act
	        List<Department> departments = departmentRepository.findAll();

	        // Print
	        departments.forEach(System.out::println);
	        
	    }

	    @Test
	    public void findById() {
	        // Arrange
	        Long id = 1L;

	        // Act
	        Department department = departmentRepository.findById(id).orElse(null);

	        // Print
	        System.out.println(department);
	        
	    }
	    
	    @Test
	    public void findByNameLikeIgnoreCase() {
	        // Arrange
	        String name = "Geográfia";

	        // Act
	       List<Department> departments = departmentRepository.findByNameLikeIgnoreCase(name);

	        // Print
	       departments.forEach(System.out::println);
	        
	    }

	    @Test
	    public void save_create() {
	        // Arrange
	        Department department = new Department();
	        department.setId(null);
	        department.setName("Tecnologia da Informacão");

	        // Act
	        department = departmentRepository.save(department);

	        // Print
	        System.out.println(department);
	        
	    }

	    @Test
	    public void save_update() {
	    	// Arrange
	        Department department = new Department();
	        department.setId(3L);
	        department.setName("Química");	        

	        // Act
	        department = departmentRepository.save(department);

	        // Print
	        System.out.println(department);
	        
	    }

	    @Test
	    public void deleteById() {
	        // Arrange
	    	Long id = 1L;

	        // Act
	    	departmentRepository.deleteById(id);
	        
	    }

	    @Test
	    public void deleteAll() {
	        // Act
	    	departmentRepository.deleteAllInBatch();
	        
	    }
}
