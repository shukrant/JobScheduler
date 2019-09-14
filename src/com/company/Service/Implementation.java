package com.company.Service;

import com.company.InputOutput.Job;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Implementation implements JobSchedulerService {

    @Override
    public void firstComeFirstServe(int threadCount, List<Job> job) {
        Map<Integer, List<String>> threads = assignJobsToThreads(threadCount, job);

        displayScheduledJobs(threads);
    }

    private Map<Integer, List<String>> assignJobsToThreads(int threadCount, List<Job> job) {
        Map<Integer, List<String>> threads = new HashMap();
        List<String> jobNames;
        int thread = 0;
        for(Job j : job) {
            if(!threads.containsKey(thread % threadCount)) {
                jobNames = new ArrayList<>();
                jobNames.add(j.getJobName());
                threads.put(thread % threadCount, jobNames);
            } else {
                jobNames = threads.get(thread % threadCount);
                jobNames.add(j.getJobName());
            }
            thread++;
        }
        return threads;
    }

    private void displayScheduledJobs(Map<Integer, List<String>> threads) {
        for (Map.Entry<Integer, List<String>> thread : threads.entrySet()) {
            System.out.print("Thread:" + thread.getKey() + " - ");
            thread.getValue().forEach(name -> {
                System.out.print(name + " ");
            });
            System.out.println();
        }

    }

}
