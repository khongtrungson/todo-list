package com.example.todolist.repositories.impl;

import com.example.todolist.models.Job;
import com.example.todolist.repositories.CustomJobRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;
@RequiredArgsConstructor
public class CustomJobRepositoryImpl implements CustomJobRepository {

    private final MongoTemplate mongoTemplate;
    @Override
    public List<Job> findCriteriaJob(Integer limit, Integer minScore, Integer maxScore, Boolean isFinished) {
        Query query = new Query();
        if(limit != null && limit > 0){
            query.limit(limit);
        }
        if(minScore != null && minScore > 0) {
            query.addCriteria(Criteria.where("score").gte(minScore));
        }
        if(maxScore != null &&  maxScore > 0) {
            query.addCriteria(Criteria.where("score").lte(maxScore));
        }
        if(isFinished != null && isFinished){
            query.addCriteria(Criteria.where("isFinished").is(isFinished));
        }
        return mongoTemplate.find(query, Job.class);
    }
}
