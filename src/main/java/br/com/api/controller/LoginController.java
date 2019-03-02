package br.com.api.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.entity.LoginEntity;
import br.com.api.entity.UserEntity;
import br.com.api.repositories.LoginRepository;
import br.com.api.repositories.UserRepository;
import br.com.api.utils.Paths;

@RestController
@RequestMapping("/login")
public class LoginController implements Paths {

	@Autowired
	private LoginRepository repository;
	
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping(path="/efetuarLogin", method=RequestMethod.POST)
	public Map<String, Object> efetuarLogin(@RequestBody Map<String, String> user) {
		LoginEntity login = new LoginEntity();
		if (user != null && !user.isEmpty()) {
			UserEntity userEnttiy = userRepository.getUsuario(user.get("userName"));
			LocalDateTime horaLogin = LocalDateTime.now();
			
			SimpleDateFormat data = new SimpleDateFormat("hh:mm:sss");
			
			Date hora =  Date.from(horaLogin.atZone(ZoneId.systemDefault()).toInstant());
			
			try {
				login.setHoraLogin(data.parse(data.format(hora)));
			} catch (ParseException e) {
				e.printStackTrace();
			}
 
			login.setUsuario(userEnttiy);
			repository.save(login);
		}
		login = repository.findOne(login.getIdLogin());
		
		Map<String, Object> response = new HashMap<>();
		response.put("login", login);
		response.put("hora", LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
		
		return response;
		
	}
}
