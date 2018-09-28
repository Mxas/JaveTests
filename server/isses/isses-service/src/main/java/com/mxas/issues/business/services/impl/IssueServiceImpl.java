package com.mxas.issues.business.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.mxas.issues.business.model.Issue;
import com.mxas.issues.business.repository.IssueRepository;
import com.mxas.issues.business.services.IssueService;

@Service
public class IssueServiceImpl implements IssueService {

    @Autowired
    private IssueRepository issueRepository;


    @Override
    public void createNew(Issue issue) {
        Assert.notNull(issue, "Issue is null!");
        Assert.notNull(issue.getNo(), "issue No must be not null!");

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
