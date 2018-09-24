package com.mxas.issues.web.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mxas.issues.model.Issue;
import com.mxas.issues.services.IssueService;


@RestController
@RequestMapping("/api/issues/")

@CrossOrigin(origins = "http://localhost:3000")
public class IssuesController {


    @Autowired
    private IssueService issueService;

    @RequestMapping(value = "all/", method = RequestMethod.GET)
    public List<Issue> findAllContacts() {

        return issueService.findAll();
    }
}
