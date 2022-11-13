package com.backend.project.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.project.entities.ComentsPublication;

public interface ComentsPublicationRepository extends JpaRepository<ComentsPublication, Long>{
	
	
	public List<ComentsPublication> findByPublicationId(long publicationId);
}
