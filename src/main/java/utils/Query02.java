package utils;

import facade.Facade;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Query02 {

    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("demo_sp3ExamPrepJPQL_jar_1.0-SNAPSHOTPU");
        Facade facade = new Facade(emf);   
        
        String firstname = "Anders";

        int result = facade.getAllStudentsByFirstName(firstname).size();
        System.out.println("Result of \"2. Find all Students in the System with the first name Anders\": " + result);
        
    }
    
}
