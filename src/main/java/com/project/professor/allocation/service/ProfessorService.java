package com.project.professor.allocation.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.professor.allocation.entity.Department;
import com.project.professor.allocation.entity.Professor;
import com.project.professor.allocation.repository.ProfessorRepository;

@Service
public class ProfessorService {

	private final ProfessorRepository professorRepository;
	private final DepartmentService departmentService;

	public ProfessorService(ProfessorRepository professorRepository, DepartmentService departmentService) {
		super();
		this.professorRepository = professorRepository;
		this.departmentService = departmentService;
	}

	public List<Professor> findAll(String name) {
		if (name == null) {
			return professorRepository.findAll();
		} else {
			return professorRepository.findByNameLikeIgnoreCase(name);
		}

	}

	public Professor findById(Long id) {

		return professorRepository.findById(id).orElse(null);
	}

	public List<Professor> findByDepartment(Long departmentId) {
		return professorRepository.findByDepartmentId(departmentId);
	}

	public Professor create(Professor professor) {

		professor.setId(null);
		return saveInternal(professor);

	}

	public Professor update(Professor professor) {

		Long id = professor.getId();
		if (id != null && professorRepository.existsById(id)) {

			return saveInternal(professor);
		} else {

			return null;
		}
	}

	public Professor saveInternal(Professor professor) {

		professor = professorRepository.save(professor);

		Department department = departmentService.findById(professor.getDepartmentId());
		professor.setDepart(department);

		return professor;
	}

	public void deleteById(Long id) {

		if (professorRepository.existsById(id)) {

			professorRepository.deleteById(id);

		}
	}

	public void deleteAll() {

		professorRepository.deleteAllInBatch();
	}

}
