
package com.queenprime.api.controller;

import java.sql.Date;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.queenprime.api.config.JwtTokenUtil;
import com.queenprime.api.domain.User;
import com.queenprime.api.service.JwtUserDetailsService;
import com.queenprime.api.service.UserService;


@Controller
//@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private PasswordEncoder bcryptEncoder;
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private JwtUserDetailsService jwtInMemoryUserDetailsService;
	
	@GetMapping("/user/all")
	public List<User> list() {
	    return userService.listAll();
	}
	
	@GetMapping("/user/{id}")
	public User getUser(@PathVariable Integer id) {
		return userService.get(id);
	}
	
	@CrossOrigin
	@PostMapping("/user/add")
	public String addUser(@RequestBody User user) {
		try {
			userService.save(user);
		} catch (Exception e) {
			e.printStackTrace();
			return e.getMessage();
		}
		return "Added successfully";
	}
	
	@PostMapping(value = "/user/authenticate", consumes = "application/x-www-form-urlencoded;charset=UTF-8")
	public String generateAuthenticationToken(@RequestParam String username, 
			@RequestParam String password) throws Exception {
		
		//System.out.println(username);
		//System.out.println(password);
		
		authenticate(username, password);
		
		User user = userService.findByUsername(username);
		
		return jwtTokenUtil.generateToken(jwtInMemoryUserDetailsService.loadUserByUsername(username));
	
	}
	
	@RequestMapping(value = "/user/register", method = RequestMethod.POST)
	public String saveUser(@RequestParam String username, 
			@RequestParam String password, @RequestParam String firstname, 
			@RequestParam String lastname,
			@RequestParam String email) throws Exception {
		User newUser = new User();
		newUser.setPassword(bcryptEncoder.encode(password));
		newUser.setEmail(email);
		newUser.setFirstName(firstname);
		newUser.setLastName(lastname);
		newUser.setUsername(username);
		newUser.setSignUpDate(new Date(Calendar.getInstance().getTime().getTime()));
		newUser.setIsSubscribed(0);
		userService.save(newUser);
		
		return "SUCCESS";
	}
	
	private void authenticate(String username, String password) throws Exception {
		Objects.requireNonNull(username);
		Objects.requireNonNull(password);
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}

	
}
