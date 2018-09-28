package com.exadel.guestregistrations.security;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.exadel.guestregistrations.model.Role;
import com.exadel.guestregistrations.model.RoleName;
import com.exadel.guestregistrations.model.User;
import com.exadel.guestregistrations.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    private User adminAdmin() {
    	User user = new User();
    	
		user.setId("ADMIN_ID");
        user.setUsername("admin");
        user.setPassword("$2a$04$ltegtDJAa/lIK8tBZrGU4uZdbQPUmvhYaYuT2KF11DgwQeQysQMJe");
        user.setActivation("Active");
        Set<Role> role = new HashSet();
        role.add(new Role(RoleName.ADMIN));
        user.setRole(role);
        
        return user;
    }
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	User user = null;
    	if("admin".equalsIgnoreCase(username)) {
    		user = adminAdmin();
    	} else {
    		user = userRepository.findByUsername(username);
    	}
        return UserPrincipal.create(user);
    }

    public UserDetails loadUserById(String id) {
        User user = null;
    	if("ADMIN_ID".equals(id)) {
        	user = adminAdmin();
        } else {
	    	user = userRepository.findById(id).orElseThrow(
	            () -> new UsernameNotFoundException("User not found with id : " + id)
	        );
        }
        return UserPrincipal.create(user);
    }
} 