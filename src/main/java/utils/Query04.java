package utils;

import demo.sp3examprepjpql.Student;
import facade.Facade;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Query04 {

    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("demo_sp3ExamPrepJPQL_jar_1.0-SNAPSHOTPU");
        Facade facade = new Facade(emf);        
        
        Student student = facade.assignStudentToSemester(7, 1);
        System.out.println("Result of \"4. Assign a new student to a semester\": "
                 + "\n" + "ID: " + student.getId() + " " 
                        + "\n" + "Fname: " + student.getFirstname() + " "
                        + "\n" + "Lname: " + student.getLastname() + " "
                        + "\n" + "SemesterID: " + student.getCurrentsemesterId().getId());
        
    }
    
}
