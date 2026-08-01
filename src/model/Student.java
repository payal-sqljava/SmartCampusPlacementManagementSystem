package model;

public class Student {
        private int studentId;
        private String name;
        private String email;
        private String password;
        private String phone;
        private String gender;
        private String collegeName;
        private String course;
        private String branch;
        private int passingYear;
        private double cgpa;
        private String skills;
        private String resumeFile;
        private double experienceYears;
        private String lastCompany;
        private String studentStatus;

        public int getStudentId() {
                return studentId;
        }

        public void setStudentId(int studentId) {
                this.studentId = studentId;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public String getEmail() {
                return email;
        }

        public void setEmail(String email) {
                this.email = email;
        }

        public String getPassword() {
                return password;
        }

        public void setPassword(String password) {
                this.password = password;
        }

        public String getPhone() {
                return phone;
        }

        public void setPhone(String phone) {
                this.phone = phone;
        }

        public String getGender() {
                return gender;
        }

        public void setGender(String gender) {
                this.gender = gender;
        }

        public String getCollegeName() {
                return collegeName;
        }

        public void setCollegeName(String collegeName) {
                this.collegeName = collegeName;
        }

        public String getCourse() {
                return course;
        }

        public void setCourse(String course) {
                this.course = course;
        }

        public String getBranch() {
                return branch;
        }

        public void setBranch(String branch) {
                this.branch = branch;
        }

        public int getPassingYear() {
                return passingYear;
        }

        public void setPassingYear(int passingYear) {
                this.passingYear = passingYear;
        }

        public double getCgpa() {
                return cgpa;
        }

        public void setCgpa(double cgpa) {
                this.cgpa = cgpa;
        }

        public String getSkills() {
                return skills;
        }

        public void setSkills(String skills) {
                this.skills = skills;
        }

        public String getResumeFile() {
                return resumeFile;
        }

        public void setResumeFile(String resumeFile) {
                this.resumeFile = resumeFile;
        }

        public double getExperienceYears() {
                return experienceYears;
        }

        public void setExperienceYears(double experienceYears) {
                this.experienceYears = experienceYears;
        }

        public String getLastCompany() {
                return lastCompany;
        }

        public void setLastCompany(String lastCompany) {
                this.lastCompany = lastCompany;
        }

        public String getStudentStatus() {
                return studentStatus;
        }

        public void setStudentStatus(String studentStatus) {
                this.studentStatus = studentStatus;
        }

        public Student(String name, String email, String password,
                       String phone, String gender, String collegeName,
                       String course, String branch, int passingYear,
                       double cgpa, String skills, String resumeFile,
                       double experienceYears, String lastCompany) {

                this.name = name;
                this.email = email;
                this.password = password;
                this.phone = phone;
                this.gender = gender;
                this.collegeName = collegeName;
                this.course = course;
                this.branch = branch;
                this.passingYear = passingYear;
                this.cgpa = cgpa;
                this.skills = skills;
                this.resumeFile = resumeFile;
                this.experienceYears = experienceYears;
                this.lastCompany = lastCompany;
        }
    }

