package com.project.professor.allocation.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.professor.allocation.entity.Allocation;
import com.project.professor.allocation.repository.AllocationRepository;

@Service
public class AllocationService {

	private final AllocationRepository allocationRepository;

	public AllocationService(AllocationRepository allocationRepository) {
		super();
		this.allocationRepository = allocationRepository;
	}

	public List<Allocation> findAll() {

		List<Allocation> allocations = allocationRepository.findAll();
		return allocations;

	}

	public Allocation findById(Long id) {

		return allocationRepository.findById(id).orElse(null);

	}

	public Allocation Create(Allocation allocation) {

		allocation.setId(null);
		return allocationRepository.save(allocation);

	}

	public Allocation Update(Allocation allocation) {

		Long id = allocation.getId();
		if (id != null && allocationRepository.existsById(id)) {

			return allocationRepository.save(allocation);
		}

		else {

			return null;
		}

	}

	public void deleteById(Long id) {

		if (allocationRepository.existsById(id)) {

			allocationRepository.deleteById(id);
		}

	}

	public void deleteAll() {

		allocationRepository.deleteAllInBatch();
	}

}
