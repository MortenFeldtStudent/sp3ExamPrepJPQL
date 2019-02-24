package utils;

import demo.sp3examprepjpql.Student;
import facade.Facade;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Query03 {

    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("demo_sp3ExamPrepJPQL_jar_1.0-SNAPSHOTPU");
        Facade facade = new Facade(emf);        
        
        Student student = facade.createStudent("Morten2", "Feldt2");
        System.out.println("Result of \"3. Insert a new Student into the system\": "
                 + "\n" + "ID: " + student.getId() + " " 
                        + "\n" + "Fname: " + student.getFirstname() + " "
                        + "\n" + "Lname: " + student.getLastname());
        
    }
    
}
