package com.project.professor.allocation.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.professor.allocation.entity.Professor;
import com.project.professor.allocation.repository.ProfessorRepository;

@Service
public class ProfessorService {

	private final ProfessorRepository professorRepository;

	public ProfessorService(ProfessorRepository professorRepository) {
		super();
		this.professorRepository = professorRepository;
	}

	public List<Professor> findAll() {

		List<Professor> professors = professorRepository.findAll();
		return professors;
	}

	public Professor findById(Long id) {

		return professorRepository.findById(id).orElse(null);
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

		if (hasCollision(professor)) {

			throw new RuntimeException("The cpf number already exists.");
		}

		else {

			return professorRepository.save(professor);
		}
	}

	public void deleteById(Long id) {

		if (professorRepository.existsById(id)) {

			professorRepository.deleteById(id);

		}
	}

	public void deleteAll() {

		professorRepository.deleteAllInBatch();
	}

	private boolean hasCollision(Professor newProfessor) {

		boolean hasCollision = false;
		List<Professor> currentProfessors = findAll();

		for (Professor currentProfessor : currentProfessors) {
			if (currentProfessor.getCpf().equals(newProfessor.getCpf())) {
				hasCollision = true;
				break;
			}
		}

		return hasCollision;
	}

}
