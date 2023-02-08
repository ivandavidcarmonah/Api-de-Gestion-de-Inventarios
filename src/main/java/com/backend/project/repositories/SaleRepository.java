package com.backend.project.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.backend.project.entities.SaleEntity;

public interface SaleRepository extends JpaRepository<SaleEntity, Long>{

	
}
