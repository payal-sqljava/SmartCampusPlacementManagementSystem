package ui;

import dao.JobDAO;
import model.Job;

import java.util.List;

public class JobViewTest {

    public static void main(String[] args) {

        JobDAO jobDAO = new JobDAO();

        List<Job> jobs = jobDAO.getAllJobs();

        for (Job job : jobs) {

            System.out.println("Job : " + job.getJobTitle());
            System.out.println("Salary : " + job.getSalary());
            System.out.println("Location : " + job.getLocation());

            System.out.println("------------------------");
        }
    }
}