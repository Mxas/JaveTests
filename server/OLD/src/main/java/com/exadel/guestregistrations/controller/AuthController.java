package com.exadel.guestregistrations.controller;

import java.net.URI;
import java.util.Collections;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.exadel.guestregistrations.model.Agent;
import com.exadel.guestregistrations.model.Role;
import com.exadel.guestregistrations.model.RoleName;
import com.exadel.guestregistrations.model.User;
import com.exadel.guestregistrations.model.UserAgent;
import com.exadel.guestregistrations.payload.ApiResponse;
import com.exadel.guestregistrations.payload.JwtAuthenticationResponse;
import com.exadel.guestregistrations.payload.LoginRequest;
import com.exadel.guestregistrations.repository.AgentRepository;
import com.exadel.guestregistrations.repository.UserRepository;
import com.exadel.guestregistrations.security.JwtTokenProvider;
import com.exadel.guestregistrations.validator.UserValidator;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;
    
    @Autowired
    UserValidator userValidator;
    
    @Autowired
    AgentRepository agentRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtTokenProvider tokenProvider;

    @InitBinder
	protected void initBinder(WebDataBinder dataBinder) {
		Object target = dataBinder.getTarget();
		if(target == null) {
			return;
		}
		
		if(target.getClass() == UserAgent.class) {
			dataBinder.setValidator(userValidator);
		}
	}
    
    @PostMapping("/signin")
    public ResponseEntity<JwtAuthenticationResponse> authenticateUser(@Valid  @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = tokenProvider.generateToken(authentication);
        return ResponseEntity.ok(new JwtAuthenticationResponse(jwt));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Validated @RequestBody UserAgent userAgent) {
        if(userRepository.findByUsername(userAgent.getUsername()) != null) {
            return new ResponseEntity(new ApiResponse(false, "Username is already taken!"), HttpStatus.BAD_REQUEST);
        }
        
        Agent agent = new Agent(userAgent.getName(), userAgent.getSurname(), null, null, null);
        agentRepository.save(agent);
        
        User user = new User(userAgent.getOfficeId(), agentRepository.findById(agent.getId()).get().getId(), userAgent.getUsername(), userAgent.getPassword(), userAgent.getActivation());

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        Role userRole = new Role(RoleName.ADMIN);

        user.setRole(Collections.singleton(userRole));

        User result = userRepository.save(user);

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/api/users/{username}")
                .buildAndExpand(result.getUsername()).toUri();

        return ResponseEntity.created(location).body(new ApiResponse(true, "User registered successfully"));
    }
}
