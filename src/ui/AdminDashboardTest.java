package ui;

import dao.ApplicationDAO;
import dao.CompanyDAO;
import dao.JobDAO;
import dao.StudentDAO;
import model.Company;
import model.Job;
import model.Student;

import java.util.List;
import java.util.Scanner;

public class AdminDashboardTest {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        StudentDAO studentDAO = new StudentDAO();
        CompanyDAO companyDAO = new CompanyDAO();
        JobDAO jobDAO = new JobDAO();
        ApplicationDAO applicationDAO = new ApplicationDAO();

        while (true) {

            System.out.println("\n========== ADMIN DASHBOARD ==========");
            System.out.println("1. View All Students");
            System.out.println("2. View All Companies");
            System.out.println("3. View All Jobs");
            System.out.println("4. View All Applications");
            System.out.println("5. Delete Student");
            System.out.println("6. Delete Company");
            System.out.println("7. Delete Job");
            System.out.println("8. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:

                    List<Student> students = studentDAO.getAllStudents();

                    for (Student student : students) {

                        System.out.println("ID : " + student.getStudentId());
                        System.out.println("Name : " + student.getName());
                        System.out.println("Email : " + student.getEmail());
                        System.out.println("Phone : " + student.getPhone());
                        System.out.println("Course : " + student.getCourse());
                        System.out.println("CGPA : " + student.getCgpa());

                        System.out.println("---------------------------");
                    }

                    break;

                case 2:

                    List<Company> companies = companyDAO.getAllCompanies();

                    for (Company company : companies) {

                        System.out.println("Company : " + company.getCompanyName());
                        System.out.println("Email : " + company.getEmail());
                        System.out.println("Phone : " + company.getPhone());
                        System.out.println("Website : " + company.getWebsite());

                        System.out.println("---------------------------");
                    }

                    break;

                case 3:

                    List<Job> jobs = jobDAO.getAllJobs();

                    for (Job job : jobs) {

                        System.out.println("Job : " + job.getJobTitle());
                        System.out.println("Location : " + job.getLocation());
                        System.out.println("Salary : " + job.getSalary());

                        System.out.println("---------------------------");
                    }

                    break;

                case 4:

                    List<String> applicants = applicationDAO.viewApplicants();

                    for (String applicant : applicants) {
                        System.out.println(applicant);
                    }

                    break;

                case 5:

                    System.out.print("Enter Student Email : ");
                    String studentEmail = sc.next();

                    if (studentDAO.deleteStudent(studentEmail)) {
                        System.out.println("Student Deleted Successfully!");
                    } else {
                        System.out.println("Student Not Found!");
                    }

                    break;

                case 6:

                    System.out.print("Enter Company Email : ");
                    String companyEmail = sc.next();

                    if (companyDAO.deleteCompany(companyEmail)) {
                        System.out.println("Company Deleted Successfully!");
                    } else {
                        System.out.println("Company Not Found!");
                    }

                    break;

                case 7:

                    System.out.print("Enter Job ID : ");
                    int jobId = sc.nextInt();

                    if (jobDAO.deleteJob(jobId)) {
                        System.out.println("Job Deleted Successfully!");
                    } else {
                        System.out.println("Job Not Found!");
                    }

                    break;

                case 8:

                    System.out.println("Thank You!");
                    sc.close();
                    return;

                default:

                    System.out.println("Invalid Choice!");
            }
        }
    }
}