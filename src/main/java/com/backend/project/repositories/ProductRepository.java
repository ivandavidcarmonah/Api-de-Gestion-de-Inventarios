package com.backend.project.repositories;



import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.project.entities.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
	public boolean existsByName(String name);
}
