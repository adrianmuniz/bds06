package com.devsuperior.movieflix.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.movieflix.dto.UserDTO;
import com.devsuperior.movieflix.services.UserService;

@RestController
@RequestMapping(value = "/users/profile")
public class UserResource {

	@Autowired
	private UserService service;
	
	@PreAuthorize("hasAnyRole('VISITOR', 'MEMBER')")
	@GetMapping()
	public ResponseEntity<UserDTO> findByProfile(String username) {
		UserDTO user = service.findByEmail(username);
		return ResponseEntity.ok().body(user);
	}
	
}
