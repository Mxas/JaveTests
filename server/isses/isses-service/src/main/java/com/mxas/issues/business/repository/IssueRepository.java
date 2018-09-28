package com.mxas.issues.business.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mxas.issues.business.model.Issue;

public interface IssueRepository extends MongoRepository<Issue, String> {
}
