package br.com.api.controller;

import java.net.URI;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.api.entity.UserEntity;
import br.com.api.repositories.UserRepository;
import br.com.api.utils.Paths;


@RestController
@RequestMapping("/user")
public class UserController implements Paths {

	@Autowired
	private UserRepository userRepository;
	
	@PostMapping(value="/insertUser")
	public ResponseEntity<UserEntity> insertUser(@RequestBody UserEntity user, HttpServletResponse response) {
		UserEntity us = userRepository.save(user);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/findUserById/{idUser}")
					.buildAndExpand(us.getIdUsuario()).toUri();
		 response.setHeader("Location", uri.toASCIIString());
		return ResponseEntity.created(uri).body(us);
	}
	
	@GetMapping(value="/findUserById/{idUser}")
	public UserEntity findById(@PathVariable Long idUser) {
		UserEntity user = userRepository.findOne(idUser);
		return user;  
	}
	
	@DeleteMapping(value="/deleteUserById/{idUser}")
	@ResponseStatus(HttpStatus.MOVED_PERMANENTLY)
	public ResponseEntity<Void> deleteById(@PathVariable Long idUser) {
		UserEntity user = userRepository.findOne(idUser);
		if (user != null) {
			userRepository.delete(idUser);
			return new ResponseEntity("Excluido com sucesso!", HttpStatus.OK);
		}
		return new ResponseEntity("Não encontrado!", HttpStatus.NOT_FOUND);
	}
}