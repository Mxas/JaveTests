package com.mxas.issues.business.services.embaddedmongo.rule;


import org.junit.Assert;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mxas.issues.business.IssueServiceApplication;
import com.mxas.issues.business.model.Issue;
import com.mxas.issues.business.services.IssueService;

@ContextConfiguration(classes = {IssueServiceApplication.class})
@RunWith(SpringJUnit4ClassRunner.class)
//@DataMongoTest manually controlling mongo instance
public class IssueServiceTest {


    @ClassRule
    public static EmbeddedMongoRule MONGO_RULE = new EmbeddedMongoRule();


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
