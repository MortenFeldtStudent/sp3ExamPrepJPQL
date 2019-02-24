package utils;

import facade.Facade;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import mappers.StudentInfo;

public class Query09 {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("demo_sp3ExamPrepJPQL_jar_1.0-SNAPSHOTPU");
        Facade facade = new Facade(emf);       

        List<StudentInfo> studentInfo = facade.getStudentInfo();
        
        System.out.println(studentInfo.get(0).studentId);
        System.out.println(studentInfo.get(0).fullName);
        System.out.println(studentInfo.get(0).classNameThisSemester);
        System.out.println(studentInfo.get(0).classDescription);

    }

}
