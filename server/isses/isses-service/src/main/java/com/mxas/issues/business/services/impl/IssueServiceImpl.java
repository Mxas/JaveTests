package com.mxas.issues.bussines.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mxas.issues.bussines.model.Issue;
import com.mxas.issues.bussines.repository.IssueRepository;
import com.mxas.issues.bussines.services.IssueService;

@Service
public class IssueServiceImpl implements IssueService {

    @Autowired
    private IssueRepository issueRepository;


    @Override
    public void createNew(Issue issue) {
        issueRepository.save(issue);
    }

    @Override
    public Issue findById(String id) {
        return issueRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Can not find by id: " + id));
    }

    @Override
    public List<Issue> findAll() {
        return issueRepository.findAll();
    }
}
