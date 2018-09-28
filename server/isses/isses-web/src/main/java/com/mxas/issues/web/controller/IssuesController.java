package com.mxas.issues.web.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mxas.issues.business.model.Issue;
import com.mxas.issues.business.services.IssueService;


@RestController
@RequestMapping("api/issues/")
public class IssuesController {


    @Autowired
    private IssueService issueService;

    @RequestMapping(value = "all", method = RequestMethod.GET)
    public List<Issue> findAllContacts() {

        return issueService.findAll();
    }

    @RequestMapping(method = RequestMethod.PUT)
    public void createNew(@RequestBody Issue issue) {
        issueService.createNew(issue);
    }

    @GetMapping("test")
    public String test() {
        return "test";
    }

}
