package utils;

import facade.Facade;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Query07 {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("demo_sp3ExamPrepJPQL_jar_1.0-SNAPSHOTPU");
        Facade facade = new Facade(emf);

        int result = facade.getStudentsWithASemester().size();
        System.out.println("Result of \"7. Find (using JPQL) the total number of students in all semesters.\": " + result);

    }

}
