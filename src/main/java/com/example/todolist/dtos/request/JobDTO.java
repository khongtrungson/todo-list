package com.example.todolist.dtos.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class JobDTO {
    private String title;
    private String description;
    private Integer score;
    @JsonProperty("is_finished")
    private Boolean isFinished;
}
