package com.HireHub.controller;

import com.HireHub.entity.Job;
import com.HireHub.entity.JobApplication;
import com.HireHub.entity.User;
import com.HireHub.repository.JobApplicationRepository;
import com.HireHub.repository.JobRepository;
import com.HireHub.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/applications")
public class JobApplicationController {

    private final JobApplicationRepository applicationRepository;
    private final UserRepository userRepository;
    private final JobRepository jobRepository;

    public JobApplicationController(JobApplicationRepository applicationRepository, UserRepository userRepository, JobRepository jobRepository) {
        this.applicationRepository = applicationRepository;
        this.userRepository = userRepository;
        this.jobRepository = jobRepository;
    }


    @PostMapping("/apply")
    public JobApplication applyJob(
            @RequestParam Long userId,
            @RequestParam Long jobId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Job job = jobRepository.findById(jobId)
                .orElseThrow(() -> new RuntimeException("Job not found"));

        JobApplication application = new JobApplication();
        application.setUser(user);
        application.setJob(job);
        application.setStatus("APPLIED");

        return applicationRepository.save(application);
    }
}