package com.mxas.issues.bussines.services.embaddedmongo.datamongotest;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mxas.issues.bussines.IssueServiceApplication;
import com.mxas.issues.bussines.model.Issue;
import com.mxas.issues.bussines.services.IssueService;
import com.mxas.issues.config.IssuesServiceConfig;

@ContextConfiguration(classes = {IssuesServiceConfig.class, IssueServiceApplication.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DataMongoTest
public class IssueServiceTest {


    @Autowired
    private IssueService issueService;


    @Test
    public void serviceNotNull() {
        Assert.assertNotNull(issueService);
    }


    @Test
    public void createIssueAndGetById() {
        String id = "test1";

        Issue issue = createDummy(id);

        issueService.createNew(issue);

        Issue loaded = issueService.findById(id);

        Assert.assertNotNull(loaded);

    }

    private Issue createDummy(String id) {
        Issue i = new Issue();
        i.setId(id);
        return i;
    }


}
