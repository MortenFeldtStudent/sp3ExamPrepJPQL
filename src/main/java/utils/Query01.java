package utils;

import facade.Facade;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Query01 {

    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("demo_sp3ExamPrepJPQL_jar_1.0-SNAPSHOTPU");
        Facade facade = new Facade(emf);       

        int result = facade.getAllStudents().size();
        System.out.println("Result of \"1. Find all Students in the system\": " + result);
        
    }
    
}
