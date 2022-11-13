package com.backend.project.security;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.backend.project.entities.RolesEntity;
import com.backend.project.entities.UserEntity;
import com.backend.project.repositories.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		UserEntity userEntity =  this.userRepository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail)
				.orElseThrow(() -> new UsernameNotFoundException("USER.ERROR.NOTFOUND_USERNAME_OR_EMAIL : " + usernameOrEmail));
		
		return new User(userEntity.getEmail(), userEntity.getPassword(), mapRoles(userEntity.getRoles()));
	}

	private Collection<? extends GrantedAuthority> mapRoles(Set<RolesEntity> roles){
		return roles.stream().map(
			rol -> new SimpleGrantedAuthority(rol.getName())).collect(Collectors.toList());
	}
}
