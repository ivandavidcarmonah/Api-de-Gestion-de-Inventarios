package com.backend.project.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.project.entities.InvoiceLineEntity;

public interface InvoiceLineRepository extends JpaRepository<InvoiceLineEntity, Long>{

	
}
