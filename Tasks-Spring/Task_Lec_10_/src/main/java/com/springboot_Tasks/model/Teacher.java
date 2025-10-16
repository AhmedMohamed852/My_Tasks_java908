package com.springboot_Tasks.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.sql.results.graph.Fetch;
import org.springframework.data.repository.cdi.Eager;

import java.util.List;

import static jakarta.persistence.FetchType.EAGER;


@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;

    private String username;

    private String password;

//_____________________________________________--
@ManyToMany(fetch = FetchType.EAGER)
@JoinTable
private List<Student> students;


}
