package com.challenge.entity;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity(name = "CHALLENGE")
@EntityListeners({})
public class Challenge {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Size(max = 100)
    @NotNull
    private String name;

    @Size(max = 50)
    @NotNull
    private String slug;

    @CreatedDate
    @Column(name = "created_at")
    private Date created_at;

    @OneToMany
    private List<Submission> submissionList;

    @OneToMany
    private List<Acceleration> accelerationList;
}
