package com.luv2code.jobportal.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "job_seeker_profile")
public class JobSeekerProfile {
    @Id
    private int userAccountId;

    @OneToOne
    @JoinColumn(name="user_account_id")
    @MapsId
    private Users userId;

    private String firstName;
    private String lastName;
    private String city;
    private String state;
    private String country;

    private String workAuthorization;
    private String employmentType;
    private String resume;

    @Column(nullable = true)
    private String profilePhoto;

    @OneToMany(targetEntity = Skills.class,cascade = CascadeType.ALL,mappedBy = "jobSeekerProfile")
    private List<Skills> skills;

    public JobSeekerProfile(Users users) {
        this.userId = users;
    }
}
