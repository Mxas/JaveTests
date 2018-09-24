package com.mxas.issues.services;

import java.util.List;

import com.mxas.issues.model.Issue;

public interface IssueService {
    void createNew(Issue issue);

    Issue findById(String id);

    List<Issue> findAll();
}
