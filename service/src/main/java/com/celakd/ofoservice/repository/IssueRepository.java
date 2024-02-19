package com.celakd.ofoservice.repository;

import com.celakd.ofoservice.entity.Issue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssueRepository extends JpaRepository<Issue, Long> {
}
