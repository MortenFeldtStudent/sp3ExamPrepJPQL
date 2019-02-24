package utils;

import facade.Facade;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Query06 {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("demo_sp3ExamPrepJPQL_jar_1.0-SNAPSHOTPU");
        Facade facade = new Facade(emf);

        String semesterName = "CLcos-v14e";

        int result = facade.getStudentsBySemester(semesterName).size();
        System.out.println("Result of \"6. Find (using JPQL) the total number of students, for a semester given the semester name as a\n"
                + "parameter.\": " + result);

    }

}
