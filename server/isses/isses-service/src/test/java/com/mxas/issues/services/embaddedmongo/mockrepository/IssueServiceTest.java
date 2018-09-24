package com.mxas.issues.services.embaddedmongo.mockrepository;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mxas.issues.config.IssuesServiceConfig;
import com.mxas.issues.model.Issue;
import com.mxas.issues.repository.IssueRepository;
import com.mxas.issues.services.IssueService;

@ContextConfiguration(classes = {IssuesServiceConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class IssueServiceTest {

    @Autowired
    private IssueService issueService;

    @MockBean
    private IssueRepository issueRepository;


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
