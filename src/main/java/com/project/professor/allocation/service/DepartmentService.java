package com.project.professor.allocation.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.professor.allocation.entity.Department;
import com.project.professor.allocation.repository.DepartmentRepository;

@Service
public class DepartmentService {

	private final DepartmentRepository departmentRepository;

	public DepartmentService(DepartmentRepository departmentRepository) {
		super();
		this.departmentRepository = departmentRepository;

	}

	public List<Department> findAll() {

		List<Department> departments = departmentRepository.findAll();
		return departments;

	}

	public Department findById(Long id) {

		return departmentRepository.findById(id).orElse(null);
	}

	public Department create(Department department) {

		department.setId(null);
		return saveInternal(department);

	}

	public Department update(Department department) {

		Long id = department.getId();
		if (id != null && departmentRepository.existsById(id)) {

			return saveInternal(department);
		} else {

			return null;
		}
	}

	public Department saveInternal(Department department) {

		if (hasCollision(department)) {

			throw new RuntimeException("The department name already exists.");
		}

		else {

			return departmentRepository.save(department);
		}
	}

	public void deleteById(Long id) {

		if (departmentRepository.existsById(id)) {

			departmentRepository.deleteById(id);
		}
	}

	public void deleteAll() {

		departmentRepository.deleteAllInBatch();
	}

	private boolean hasCollision(Department newDepartment) {

		boolean hasCollision = false;
		List<Department> currentDepartments = findAll();

		for (Department currentDepartment : currentDepartments) {
			if (currentDepartment.getName().equals(newDepartment.getName())) {
				hasCollision = true;
				break;
			}
		}

		return hasCollision;
	}

}
