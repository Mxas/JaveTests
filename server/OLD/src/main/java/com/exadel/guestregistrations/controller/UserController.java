package com.exadel.guestregistrations.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.exadel.guestregistrations.model.Agent;
import com.exadel.guestregistrations.model.User;
import com.exadel.guestregistrations.model.UserAgent;
import com.exadel.guestregistrations.service.AgentService;
import com.exadel.guestregistrations.service.UserService;
import com.exadel.guestregistrations.service.UsernameAlreadyExistsException;
import com.exadel.guestregistrations.validator.UserValidator;


@RestController
@RequestMapping("/api/users")

@CrossOrigin
public class UserController {
	
	@Autowired
	UserValidator userValidator;
		
	private static Logger logger = LogManager.getLogger(UserController.class);
	
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
	
	@Autowired
	private UserService userService;
	@Autowired
	private AgentService agentService;
	
	@RequestMapping(method = RequestMethod.GET)
    public List<UserAgent> findAllUsers() {
        List<User> users = userService.findAllUsers();
        List<UserAgent> userAgents = new ArrayList<UserAgent>();
        
        users.forEach((user) -> {
        	userAgents.add(new UserAgent(user, agentService.findById(user.getAgentId())));
        });
        
        return userAgents;
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/addUser")
    public String save(@RequestBody @Validated UserAgent userAgent) throws UsernameAlreadyExistsException {

		Agent agent = new Agent(userAgent.getName(), userAgent.getSurname(), null, null, null);
		agentService.addUserAgent(userAgent);
		
		User user = new User(userAgent.getOfficeId(), agentService.findById(agent.getId()).getId(), userAgent.getUsername(), userAgent.getPassword(), userAgent.getActivation());
		
		userService.addUser(user);
		
        return user.getId();
    }
	
	@RequestMapping(method=RequestMethod.GET, value="/{id}")
	public UserAgent getUser(@PathVariable final String id){
		User user = userService.findById(id);
		Agent agent = agentService.findById(user.getAgentId());
		
		return new UserAgent(user, agent);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/{id}")
    public String delete(@PathVariable String id) {
		UserAgent userAgent = getUser(id);
		
		agentService.deleteAgent(userAgent.getAgentId());
		userService.deleteUser(id);
		
		logger.info("User successfully removed");
		
        return "user deleted";
    }
	
	@RequestMapping(method = RequestMethod.PUT)
    public String update(@RequestBody @Validated UserAgent userAgent) {
		User user = new User(userAgent.getOfficeId(), userAgent.getAgentId(), userAgent.getUsername(), userAgent.getPassword(), userAgent.getActivation());
		user.setId(userAgent.getId());
		
		Agent agent = new Agent(userAgent.getName(), userAgent.getSurname(), null, null, null);
		agent.setId(userAgent.getAgentId());
		
		userService.editUser(user);
		agentService.update(agent);
		
		return user.getId();
    }
}