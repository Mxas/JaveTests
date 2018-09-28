package com.exadel.guestregistrations.controller;

import java.util.List;

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

import com.exadel.guestregistrations.model.Office;
import com.exadel.guestregistrations.service.OfficeService;
import com.exadel.guestregistrations.validator.OfficeValidator;




@RestController
@RequestMapping("/api/offices")

@CrossOrigin
public class OfficeController {
	
	@Autowired
	private OfficeService officeService;
	
	@Autowired
	private OfficeValidator officeValidator;
	
	private static Logger logger = LogManager.getLogger(OfficeController.class);
	
	@InitBinder
	protected void initBinder(WebDataBinder dataBinder) {
		Object target = dataBinder.getTarget();
		if(target == null) {
			return;
		}
		
		if(target.getClass() == Office.class) {
			dataBinder.setValidator(officeValidator);
		}
	}

	@RequestMapping(method = RequestMethod.GET)
    public List<Office> findAllOffices() {
        return officeService.findAllOffices();
    }
	
	@RequestMapping(method=RequestMethod.POST, value="/addOffice")
    public String save(@RequestBody @Validated Office office) {
		officeService.addOffice(office);
		logger.info("The record of the office located in " + office.getAdress() + " added successfully.");
        return office.getId();
    }
	@RequestMapping(method=RequestMethod.GET, value="/{id}")
	public Office getOffice(@PathVariable final String id){
		return officeService.findById(id);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/{id}")
	public Office updateOffice(@RequestBody @Validated Office office) {
		Office o = officeService.findById(office.getId());
		
		officeService.addOffice(office);
		logger.info("The record of the office located in " + office.getAdress() + " edited successfully.");
		return o;
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/{id}")
    public String delete(@PathVariable String id) {		
		logger.info("The record of the office located in " + officeService.findById(id).getAdress() + " deleted successfully.");
		officeService.deleteOffice(id);
        return "office deleted";
    }
}
