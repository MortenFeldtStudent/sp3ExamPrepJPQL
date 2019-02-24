package utils;

import facade.Facade;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import mappers.StudentInfo;

public class Query10 {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("demo_sp3ExamPrepJPQL_jar_1.0-SNAPSHOTPU");
        Facade facade = new Facade(emf);       

        int studentId = 4;
        
        StudentInfo studentInfo = facade.getStudentInfo(studentId);
        
        System.out.println(studentInfo.studentId);
        System.out.println(studentInfo.fullName);
        System.out.println(studentInfo.classNameThisSemester);
        System.out.println(studentInfo.classDescription);

    }

}
