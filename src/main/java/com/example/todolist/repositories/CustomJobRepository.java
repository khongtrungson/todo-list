package com.example.todolist.repositories;

import com.example.todolist.models.Job;

import java.util.List;

public interface CustomJobRepository {

    List<Job> findCriteriaJob(Integer limit, Integer minScore, Integer maxScore, Boolean isFinished);
}
