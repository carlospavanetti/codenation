package com.challenge.entity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class User {
    @OneToMany
    private List<Submission> submissions;

    @OneToMany
    private List<Candidate> candidates;

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
