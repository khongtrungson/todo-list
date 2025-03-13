package com.example.todolist.mappers;

import com.example.todolist.dtos.request.JobDTO;
import com.example.todolist.models.Job;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.UUID;
// class này sẽ thực hiện việc ánh xạ qua lại giữa model và DTO
public class JobMapper {
    public static Job toJob(JobDTO jobDTO) {
        Job job = new Job();
        job.setId(UUID.randomUUID().toString());
        job.setDescription(jobDTO.getDescription());
        job.setTitle(jobDTO.getTitle());
        job.setScore(jobDTO.getScore());
        job.setCreatedTime(ZonedDateTime.now().toString());
        job.setUpdatedTime(ZonedDateTime.now().toString());
        return job;
    }
    public static void updateJob(JobDTO job,Job currentJob) {
        if(job.getTitle() != null) {
            currentJob.setTitle(job.getTitle());
        }
        if(job.getDescription() != null) {
            currentJob.setDescription(job.getDescription());
        }
        if(job.getScore() != null) {
            currentJob.setScore(job.getScore());
        }
        if(job.getIsFinished() != null) {
            currentJob.setIsFinished(job.getIsFinished());
        }
        currentJob.setUpdatedTime(ZonedDateTime.now().toString());
    }
}
