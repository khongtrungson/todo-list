package com.example.todolist;

import com.example.todolist.dtos.request.JobDTO;
import com.example.todolist.repositories.JobRepository;
import com.example.todolist.services.JobService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.io.IOException;
import java.util.List;

@SpringBootApplication
@EnableMongoRepositories
@Slf4j
public class TodoListApplication {

    public static void main(String[] args) {
        SpringApplication.run(TodoListApplication.class, args);
    }
    @Bean
    CommandLineRunner initData(@Autowired JobService jobService, @Autowired JobRepository repository) {
        return args -> {
            if (repository.count() < 15) { // Chỉ insert nếu DB rỗng
                List<JobDTO> jobs = List.of(
                        new JobDTO("Job 1", "Complete the project", 5, false),
                        new JobDTO("Job 2", "Review the code", 4, true),
                        new JobDTO("Job 3", "Write documentation", 3, false),
                        new JobDTO("Job 4", "Test the application", 5, true),
                        new JobDTO("Job 5", "Refactor the code", 4, false),
                        new JobDTO("Job 6", "Fix bugs", 2, true),
                        new JobDTO("Job 7", "Deploy the app", 5, false),
                        new JobDTO("Job 8", "Optimize performance", 4, true),
                        new JobDTO("Job 9", "Improve UI/UX", 3, false),
                        new JobDTO("Job 10", "Update dependencies", 2, true)
                );
                for (JobDTO job : jobs) {
                    jobService.addJob(job);
                }
                log.info("inserted " + jobs.size() + " jobs");
            }
        };
    }
}
