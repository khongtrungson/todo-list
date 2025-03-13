package com.example.todolist.services.impl;

import com.example.todolist.constant.Message;
import com.example.todolist.dtos.request.JobDTO;
import com.example.todolist.exceptions.NotFoundException;
import com.example.todolist.mappers.JobMapper;
import com.example.todolist.models.Job;
import com.example.todolist.repositories.JobRepository;
import com.example.todolist.services.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JobServiceImp implements JobService {
    private final JobRepository jobRepository;

    @Override
    public void addJob(JobDTO jobDTO) {
        jobRepository.save(JobMapper.toJob(jobDTO));
    }

    @Override
    public void updateJob(String id, JobDTO jobDto) {
        // kiểm tra tồn tại của id
        Job currentJob = jobRepository.findById(id).orElseThrow(
                () -> new NotFoundException(Message.JOB_NOT_FOUND)
        );
        JobMapper.updateJob(jobDto,currentJob);
        jobRepository.save(currentJob);
    }

    @Override
    public void deleteJob(String id) {
        jobRepository.deleteById(id);
    }

    @Override
    public List<Job> searchJobs(Integer limit, Integer minScore, Integer maxScore, Boolean isFinished) {
        return jobRepository.findCriteriaJob(limit, minScore, maxScore, isFinished);
    }
}
