package com.HireHub.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
public class JobApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Job job;

    private String status; // APPLIED, SHORTLISTED, REJECTED

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "JobApplication{" +
                "id=" + id +
                ", user=" + user +
                ", job=" + job +
                ", status='" + status + '\'' +
                '}';
    }

    public JobApplication() {
    }

    public JobApplication(Long id, User user, Job job, String status) {
        this.id = id;
        this.user = user;
        this.job = job;
        this.status = status;
    }
}