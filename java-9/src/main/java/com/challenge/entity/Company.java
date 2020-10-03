package com.challenge.entity;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity(name = "COMPANY")
@EntityListeners({})
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

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
    private List<Candidate> candidateList;
}