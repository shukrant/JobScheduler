package com.company.Service;

import java.util.List;

import com.company.InputOutput.Job;

public interface JobSchedulerService {

    void shortestJobFirst(int threadCount, List<Job> job);

    void firstComeFirstServe(int threadCount, List<Job> job);

    void fixedPriorityScheduling(int threadCount, List<Job> job);

}
