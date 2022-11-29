package com.vodafone.model;

import jakarta.validation.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 30)
    @NotBlank
    private String firstName;

    @Column(nullable = false, length = 30)
    @NotBlank
    private String lastName;

    @Column(nullable = false)
    @NotNull
    @Min(2000)
    private Integer salary;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return String.format("\n-------------------------------------------\nUser\n" +
                        "name: %s %s\t\t\tsalary: %d\n" +
                        "-------------------------------------------",
                firstName, lastName, salary);
    }
}
