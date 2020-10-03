package com.challenge.entity;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity(name = "CANDIDATE")
@EntityListeners({})
public class Candidate {

    @EmbeddedId
    private CandidateIdentity candidateIdentity;

    @NotNull
    private Integer status;

    @CreatedDate
    @Column(name = "created_at")
    private Date created_at;
}
