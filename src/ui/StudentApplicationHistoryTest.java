package ui;

import dao.ApplicationDAO;

import java.util.List;

public class StudentApplicationHistoryTest {

    public static void main(String[] args) {

        ApplicationDAO dao = new ApplicationDAO();

        List<String> list = dao.studentApplications(3);

        for(String s:list){
            System.out.println(s);
        }

    }
}