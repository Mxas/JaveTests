package com.mxas.issues.bussines.services;

import java.util.List;

import com.mxas.issues.bussines.model.Issue;

public interface IssueService {
    void createNew(Issue issue);

    Issue findById(String id);

    List<Issue> findAll();
}
