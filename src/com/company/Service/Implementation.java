package com.company.Service;

import com.company.InputOutput.Job;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Comparator;

public class Implementation implements JobSchedulerService {

    @Override
    public void firstComeFirstServe(int threadCount, List<Job> job) {
        System.out.println("FCFS-");
        Map<Integer, List<String>> threads = assignJobsToThreads(threadCount, job);

        displayScheduledJobs(threads);
    }

    @Override
    public void fixedPriorityScheduling(int threadCount, List<Job> job) {
        System.out.println("FPS:");

        List<Job> jobs = (List<Job>) ((ArrayList) job).clone();
        jobs.sort(new Comparator<Job>() {
            @Override
            public int compare(Job j1, Job j2) {
                if (j1.getPriority() == j2.getPriority()) {
                    if (j1.getUserType() == j2.getUserType()) {
                        return (int) (j2.getDuration() - j1.getDuration());
                    } else {
                        return j1.getUserType() - j2.getUserType();
                    }
                }
                return (int) (j1.getPriority() - j2.getPriority());
            }
        });

        Map<Integer, List<String>> threads = assignJobsToThreads(threadCount, jobs);

        displayScheduledJobs(threads);
    }

    @Override
    public void shortestJobFirst(int threadCount, List<Job> job) {
        System.out.println("SJFS:");

        List<Job> jobs = (List<Job>) ((ArrayList) job).clone();
        jobs.sort(new Comparator<Job>() {
            @Override
            public int compare(Job j1, Job j2) {
                if (j1.getDuration() == j2.getDuration()) {
                    return j1.getPriority() - j2.getPriority();
                } else  {
                    return (int) (j1.getDuration() - j2.getDuration());
                }
            }
        });

        Map<Integer, List<String>> threads = assignJobsToThreads(threadCount, jobs);

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
