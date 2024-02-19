package com.celakd.ofoservice.service;

import com.celakd.ofoservice.entity.Issue;

import java.util.List;

public interface IssueService {
    Issue addIssueToBacklog(Issue issue);

    List<Issue> getAllIssues();

    Issue getIssueById(Long id);
}
