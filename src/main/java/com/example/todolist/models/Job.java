package com.example.todolist.models;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

@Document(collection = "jobs")
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Job {
    @Id
    private String id;
    private String title;
    private String description;
    private Boolean isFinished;
    private String createdTime;
    private String updatedTime;
    private Integer score;
}
