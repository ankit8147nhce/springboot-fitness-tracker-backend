package com.project.fitness.model;

import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.Map;

@Entity
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String Id;


    //What does @Enumerated do?
    //By default, JPA does not know how to store enums.
    //So we explicitly tell it: Store enum as String in DB: @Enumerated(EnumType.STRING)
    @Enumerated(EnumType.STRING)
    private ActivityType type;

    //to store JSON values in the Database
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "json")
    private Map<String,Object> additionalMetrics;

    private Integer duration;
    private Integer caloriesBurned;
    private LocalDateTime startTime;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


}
