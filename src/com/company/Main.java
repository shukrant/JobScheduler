package com.company;
import java.util.ArrayList;
import java.util.List;
import com.company.InputOutput.Job;
import com.company.Service.JobSchedulerService;
import com.company.Service.Implementation;

public class Main {

    public static void main(String[] args) {
        JobSchedulerService jobScheduler = new Implementation();
        Job job1 = new Job("J1", 10, 0, 10, 0);
        Job job2 = new Job("J2", 20, 0, 40, 1);
        Job job3 = new Job("J3", 15, 2, 40, 0);
        Job job4 = new Job("J4", 30, 1, 40, 2);
        Job job5 = new Job("J5", 10, 2, 30, 2);

        List<Job> jobs = new ArrayList<>();
        jobs.add(job1);
        jobs.add(job2);
        jobs.add(job3);
        jobs.add(job4);
        jobs.add(job5);

        jobScheduler.firstComeFirstServe(2, jobs);
    }
}
