package ui;

import dao.ApplicationDAO;

public class UpdateApplicationStatusTest {

    public static void main(String[] args) {

        ApplicationDAO dao = new ApplicationDAO();

        boolean result = dao.updateApplicationStatus(
                1,
                "Shortlisted"
        );

        if(result){
            System.out.println("Application Updated Successfully!");
        }else{
            System.out.println("Update Failed!");
        }

    }
}