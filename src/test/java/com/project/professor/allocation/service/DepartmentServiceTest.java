package com.project.professor.allocation.service;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import com.project.professor.allocation.entity.Department;

@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")
public class DepartmentServiceTest {
	
	@Autowired
	DepartmentService departmentService;
	
	@Test
	public void findAll() {
		
		List<Department> departments = departmentService.findAll(null);
		
		departments.forEach(System.out::println);
	}
	
    @Test
    public void findAllByName() {
        // Arrange
        String name = "department";

        // Act
        List<Department> departments = departmentService.findAll(name);

        // Print
        departments.forEach(System.out::println);
    }
	
	@Test
	public void findById() {
		
		Long id = 1L;
		System.out.println(departmentService.findById(id));
		
	}
	
	@Test
	public void save() {
		
		Department department = new Department();
		department.setId(null);
		department.setName("Engenharia Mecânica");
		
		department = departmentService.create(department);
		
		System.out.println(department);
	}
	
	@Test
	public void update() {
		
		Department department = new Department();
		department.setId(2L);
		department.setName("Engenharia Mecânica");
		
		department = departmentService.update(department);
		
		System.out.println(department);
		
	}
	
	@Test
	public void deleteById() {
		
		Long id = 1L;
		departmentService.deleteById(id);
		
	}
	
	@Test
	public void deleteAll() {
		
		departmentService.deleteAll();
		
	}

}
