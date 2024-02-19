package com.celakd.ofoservice.service.impl;

import com.celakd.ofoservice.entity.Issue;

import com.celakd.ofoservice.exception.IssueException;
import com.celakd.ofoservice.repository.IssueRepository;
import com.celakd.ofoservice.service.IssueService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class IssueServiceImpl implements IssueService {
    @Autowired
    private IssueRepository issueRepository;

    @Override
    public Issue addIssueToBacklog(Issue issue) {
        return issueRepository.save(issue);
    }

    @Override
    public List<Issue> getAllIssues() {
        if (issueRepository.findAll().isEmpty()) {
            throw new IssueException("The backlog is empty.");
        }
        return issueRepository.findAll();
    }

    @Override
    public Issue getIssueById(Long id) {
        if (issueRepository.findById(id).isEmpty()) {
            throw new IssueException("Issue does not exist.");
        }
        return issueRepository.findById(id).get();
    }
}
