package utils;

import demo.sp3examprepjpql.Teacher;
import facade.Facade;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Query08 {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("demo_sp3ExamPrepJPQL_jar_1.0-SNAPSHOTPU");
        Facade facade = new Facade(emf);

        Teacher teacher = facade.getTeacherWhoTeachesMostSemesters();
        System.out.println("Result of \"8. Find (using JPQL) the teacher who teaches the most semesters.\": " + teacher.getId());

    }

}
