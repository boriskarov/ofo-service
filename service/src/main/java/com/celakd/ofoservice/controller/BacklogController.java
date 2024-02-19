package com.celakd.ofoservice.controller;

import com.celakd.ofoservice.entity.Issue;
import com.celakd.ofoservice.service.IssueService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/backlog")
@RequiredArgsConstructor
public class BacklogController {
    private final IssueService issueService;

    @PostMapping("/create")
    public Issue addIssueToBacklog(@RequestBody Issue issue){
        return issueService.addIssueToBacklog(issue);
    }

    @GetMapping("/issues")
    public List<Issue> getAllIssues(){
        return issueService.getAllIssues();
    }

    @GetMapping("/{id}")
    public Issue getIssueById(@PathVariable Long id){
        return issueService.getIssueById(id);
    }
}
