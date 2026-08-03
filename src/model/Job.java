package model;

public class Job {
    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getRequiredSkills() {
        return requiredSkills;
    }

    public void setRequiredSkills(String requiredSkills) {
        this.requiredSkills = requiredSkills;
    }

    public String getRequiredCourse() {
        return requiredCourse;
    }

    public void setRequiredCourse(String requiredCourse) {
        this.requiredCourse = requiredCourse;
    }

    public double getMinimumCgpa() {
        return minimumCgpa;
    }

    public void setMinimumCgpa(double minimumCgpa) {
        this.minimumCgpa = minimumCgpa;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLastDate() {
        return lastDate;
    }

    public void setLastDate(String lastDate) {
        this.lastDate = lastDate;
    }

    public double getExperienceRequired() {
        return experienceRequired;
    }

    public void setExperienceRequired(double experienceRequired) {
        this.experienceRequired = experienceRequired;
    }

    public String getJobStatus() {
        return jobStatus;
    }

    public void setJobStatus(String jobStatus) {
        this.jobStatus = jobStatus;
    }

    private int jobId;
    private int companyId;
    private String jobTitle;
    private String jobDescription;
    private double salary;
    private String requiredSkills;
    private String requiredCourse;
    private double minimumCgpa;
    private String location;
    private String lastDate;
    private double experienceRequired;
    private String jobStatus;


public Job(int companyId,
           String jobTitle,
           String jobDescription,
           double salary,
           String requiredSkills,
           String requiredCourse,
           double minimumCgpa,
           String location,
           String lastDate,
           double experienceRequired) {

    this.companyId = companyId;
    this.jobTitle = jobTitle;
    this.jobDescription = jobDescription;
    this.salary = salary;
    this.requiredSkills = requiredSkills;
    this.requiredCourse = requiredCourse;
    this.minimumCgpa = minimumCgpa;
    this.location = location;
    this.lastDate = lastDate;
    this.experienceRequired = experienceRequired;
}
}