package com.luv2code.jobportal.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "recuiter_profile")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecuiterProfile {
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

    @Column(nullable = true)
    private String profilePhoto;


    public RecuiterProfile(Users users) {
        this.userId = users;
    }
}
