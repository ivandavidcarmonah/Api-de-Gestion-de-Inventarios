package com.backend.project.repositories;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.project.entities.GenderEntity;
import com.backend.project.entities.LanguageEntity;
import com.backend.project.entities.UserEntity;

public interface LanguageRepository extends JpaRepository<LanguageEntity, Long>{
	
}
