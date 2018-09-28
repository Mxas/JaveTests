package com.mxas.issues.bussines.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mxas.issues.bussines.model.Issue;

public interface IssueRepository extends MongoRepository<Issue, String> {
}
