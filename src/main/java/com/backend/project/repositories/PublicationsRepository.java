package com.backend.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.project.entities.PublicationsEntity;

public interface PublicationsRepository extends JpaRepository<PublicationsEntity, Long>{

}
