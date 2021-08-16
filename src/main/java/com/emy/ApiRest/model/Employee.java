package com.emy.ApiRest.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Table(name = "employee")
public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false,updatable = false)
    private Long empId;
    private String firstName;
    private String lastName;
    private String gender;
    private int age;
    private String contactAddress;
    @Column(nullable = false,updatable = false)
    private String empEmail;

    private String department;

}
