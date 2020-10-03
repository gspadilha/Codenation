package com.challenge.entity;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@Entity(name = "SUBMISSION")
@EntityListeners({})
public class Submission {

    @EmbeddedId
    private SubmissionIdentity submissionIdentity;

    @NotNull
    private Float score;

    @CreatedDate
    @Column(name = "created_at")
    private Date created_at;
}
