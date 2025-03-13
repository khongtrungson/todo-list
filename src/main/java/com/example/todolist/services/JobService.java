package com.example.todolist.services;

import com.example.todolist.dtos.request.JobDTO;
import com.example.todolist.models.Job;
import org.springframework.boot.autoconfigure.batch.BatchProperties;

import java.util.List;

public interface JobService {
    void addJob(JobDTO job);
    void updateJob(String id,JobDTO job);
    void deleteJob(String id);
    List<Job> searchJobs(Integer limit,Integer minScore,Integer maxScore,Boolean isFinished);
}
