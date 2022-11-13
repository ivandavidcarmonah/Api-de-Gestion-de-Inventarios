package com.backend.project.repositories;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;


import com.backend.project.entities.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long>{

	public Optional<UserEntity> findByEmail(String email);
	
	public Optional<UserEntity> findByUsernameOrEmail(String username, String email);
	
	public Optional<UserEntity> findByUsername(String username);
	
	public Boolean existsByUsername(String username);
	
	public boolean existsByEmail(String email);
	
}
