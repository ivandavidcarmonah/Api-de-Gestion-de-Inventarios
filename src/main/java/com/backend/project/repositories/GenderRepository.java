package com.backend.project.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.project.entities.GenderEntity;

public interface GenderRepository extends JpaRepository<GenderEntity, Long>{
	
}
