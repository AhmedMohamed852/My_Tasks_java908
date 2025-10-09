package com.springbootproject_1.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique = true , nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;



    public Teacher(String username, String password) {
        this.username = username;
        this.password = password;
    }

}
