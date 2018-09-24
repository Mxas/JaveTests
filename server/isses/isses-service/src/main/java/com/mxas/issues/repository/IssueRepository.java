package com.mxas.issues.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mxas.issues.model.Issue;

public interface IssueRepository extends MongoRepository<Issue, String> {
}
