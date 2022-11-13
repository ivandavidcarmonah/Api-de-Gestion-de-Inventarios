package com.backend.project.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.project.entities.BarTableEntity;
import com.backend.project.entities.CompanyEntity;

public interface BarTableRepository extends JpaRepository<BarTableEntity, Long> {
	
	//List<BarTableEntity> findAllByIdCompany(long idCompany);
	List<BarTableEntity> findAllByCompany(CompanyEntity company);
	
}
