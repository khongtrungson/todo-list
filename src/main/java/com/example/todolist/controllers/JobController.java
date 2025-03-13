package com.example.todolist.controllers;

import com.example.todolist.constant.Message;
import com.example.todolist.dtos.request.JobDTO;
import com.example.todolist.models.Job;
import com.example.todolist.repositories.JobRepository;
import com.example.todolist.services.JobService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobs")
@RequiredArgsConstructor
@Validated
@Slf4j
public class JobController {
    private final JobService jobService;
    @GetMapping("/test")
    public String test(){
        return "hello";
    }
    @GetMapping("")
    public List<Job> searchJob(
            @RequestParam(value = "limit",required = false) Integer limit,
            @RequestParam(value = "min_score",required = false) Integer minScore,
            @RequestParam(value = "max_score",required = false) Integer maxScore,
            @RequestParam(value = "is_finished",required = false)Boolean isFinished) {
        log.info("searching jobs ...");
       return jobService.searchJobs(limit, minScore, maxScore, isFinished);
    }
    @PostMapping("")
    public String createJob(@RequestBody JobDTO job) {
        jobService.addJob(job);
        return Message.CREATED_SUCCESSFULLY;
    }
    @PutMapping("/{id}")
    public String updateJob(@PathVariable("id") String id,@RequestBody JobDTO job) {
        jobService.updateJob(id,job);
        return Message.UPDATED_SUCCESSFULLY;
    }
    @DeleteMapping("/{id}")
    public String deleteJob(@PathVariable("id") String id) {
        jobService.deleteJob(id);
        return Message.DELETED_SUCCESSFULLY;
    }
}
