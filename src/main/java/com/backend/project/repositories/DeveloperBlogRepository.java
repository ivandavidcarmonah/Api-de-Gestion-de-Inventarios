package com.backend.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.project.entities.DeveloperBlogEntity;

public interface DeveloperBlogRepository extends JpaRepository<DeveloperBlogEntity, Long>{

}
