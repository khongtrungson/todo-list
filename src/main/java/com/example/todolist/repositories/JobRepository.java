package com.example.todolist.repositories;

import com.example.todolist.models.Job;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JobRepository extends MongoRepository<Job, String>,CustomJobRepository {

}
