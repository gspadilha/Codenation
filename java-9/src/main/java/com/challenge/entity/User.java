package com.challenge.entity;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity(name = "USER")
@EntityListeners({})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Size(max = 100)
    @NotNull
    @Column(name = "fullname")
    private String fullname;

    @Size(max = 100)
    @NotNull
    @Email
    private String email;

    @Size(max = 50)
    @NotNull
    private String nickname;

    @Size(max = 255)
    @NotNull
    private String password;

    @CreatedDate
    @Column(name = "created_at")
    private Date created_at;

    @OneToMany
    private List<Candidate> candidateList;

    @OneToMany
    private List<Submission> submissionList;
}
