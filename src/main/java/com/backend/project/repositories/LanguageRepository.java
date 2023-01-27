package com.backend.project.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.project.entities.LanguageEntity;

public interface LanguageRepository extends JpaRepository<LanguageEntity, Long>{
	
}
