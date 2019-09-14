package com.company.InputOutput;

public class Job {
    private String jobName;
    private double duration;
    private int priority;
    private double deadline;
    private int userType;

    public Job(String jobName, double duration, int priority, double deadline, int userType) {
        this.jobName = jobName;
        this.duration = duration;
        this.priority = priority;
        this.deadline = deadline;
        this.userType = userType;
    }

    // Getters

    public String getJobName() {
        return jobName;
    }

    public double getDuration() {
        return duration;
    }

    public int getPriority() {
        return priority;
    }

    public double getDeadline() {
        return deadline;
    }

    public int getUserType() {
        return userType;
    }

    // Setters

    void setJobName(String jobName) {
        this.jobName = jobName;
    }

    void setDuration(double duration) {
        this.duration = duration;
    }

    void setPriority(int priority) {
        this.priority = priority;
    }

    void setDeadline(double deadline) {
        this.deadline = deadline;
    }

    void setUserType(int userType) {
        this.userType = userType;
    }

    @Override
    public String toString() {
        return "Input [jobName=" + jobName + ", duration=" + duration + ", priority=" + priority + ", deadline="
                + deadline + ", userType=" + userType + "]";
    }


}
