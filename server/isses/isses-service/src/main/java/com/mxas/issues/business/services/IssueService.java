package com.mxas.issues.business.services;

import java.util.List;

import com.mxas.issues.business.model.Issue;

public interface IssueService {
    void createNew(Issue issue);

    Issue findById(String id);

    List<Issue> findAll();
}
