package utils;

import facade.Facade;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Query05 {

    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("demo_sp3ExamPrepJPQL_jar_1.0-SNAPSHOTPU");
        Facade facade = new Facade(emf);   
        
        String lastname = "And";

        int result = facade.getAllStudentsByLastName(lastname).size();
        System.out.println("Result of \"5. Find (using JPQL) all Students in the system with the last name And\": " + result);
        
    }
    
}
