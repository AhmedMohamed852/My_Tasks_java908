package com.springboot_Tasks.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Employees_Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id" , nullable = false ,unique = true)
    private int id;

    @Column(name = "name" ,nullable = false)
    private String name;

    @Column(name = "age" ,nullable = false)
    private int age;

    private String phoneNumber;

    public Employees_Task(String name, int age, String phoneNumber) {
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
    }
}
