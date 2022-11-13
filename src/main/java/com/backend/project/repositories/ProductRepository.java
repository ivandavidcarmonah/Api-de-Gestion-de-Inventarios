package com.backend.project.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.project.entities.CompanyEntity;
import com.backend.project.entities.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
	
	public List<ProductEntity> findAllByCompany(long idCompany);
	public Page<ProductEntity> findAllByCompany(long idCompany, Pageable pageable);
	public Page<ProductEntity> findAllByCompany(CompanyEntity compamny, Pageable pageable);
	
}
