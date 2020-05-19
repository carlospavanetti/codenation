package com.challenge.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class User {
    @OneToMany
    private List<Submission> submissions;

    @OneToMany
    private List<Candidate> candidates;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreatedDate
    private Date createdAt;

    @NotNull
    @Size(max = 100)
    private String fullname;

    @Email
    @NotNull
    @Size(max = 100)
    private String email;


    @NotNull
    @Size(max = 50)
    private String nickname;

    @NotNull
    @Size(max = 255)
    private String password;
}
