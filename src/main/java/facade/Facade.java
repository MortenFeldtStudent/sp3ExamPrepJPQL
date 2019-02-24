package facade;

import demo.sp3examprepjpql.Semester;
import demo.sp3examprepjpql.Student;
import demo.sp3examprepjpql.Teacher;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import mappers.StudentInfo;

public class Facade {

    EntityManagerFactory emf;

    public Facade(EntityManagerFactory emf) {
        this.emf = emf;
    }

    //1. Find all Students in the system
    public List<Student> getAllStudents() {
        EntityManager em = emf.createEntityManager();

        try {
            List<Student> studentList = new ArrayList();
            Query q = em.createNamedQuery("Student.findAll");
            studentList = q.getResultList();
            return studentList;
        } finally {
            em.close();
        }

    }

    //2. Find all Students in the System with the first name Anders
    public List<Student> getAllStudentsByFirstName(String firstname) {
        EntityManager em = emf.createEntityManager();

        try {
            List<Student> studentList = new ArrayList();
            Query q = em.createNamedQuery("Student.findByFirstname");
            q.setParameter("firstname", firstname);
            studentList = q.getResultList();
            return studentList;
        } finally {
            em.close();
        }

    }

    //3. Insert a new Student into the system
    public Student createStudent(String firstName, String lastName) {
        Student student = new Student(firstName, lastName);
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(student);
            em.getTransaction().commit();
            return student;
        } finally {
            em.close();
        }
    }

    //4. Assign a new student to a semester
    public Student assignStudentToSemester(long studentId, long semesterId) {
        EntityManager em = emf.createEntityManager();
        Student student = em.find(Student.class, studentId);
        Semester semester = em.find(Semester.class, semesterId);

        try {
            em.getTransaction().begin();
            student.setCurrentsemesterId(semester);
            em.getTransaction().commit();
            return student;
        } finally {
            em.close();
        }
    }

    //5. Find (using JPQL) all Students in the system with the last name And
    public List<Student> getAllStudentsByLastName(String lastname) {
        EntityManager em = emf.createEntityManager();

        try {
            List<Student> studentList = new ArrayList();
            Query q = em.createNamedQuery("Student.findByLastname");
            q.setParameter("lastname", lastname);
            studentList = q.getResultList();
            return studentList;
        } finally {
            em.close();
        }

    }

    //6. Find (using JPQL) the total number of students, for a semester given the semester name as a parameter.
    public List<Student> getStudentsBySemester(String semesterName) {
        EntityManager em = emf.createEntityManager();

        try {
            List<Student> studentList = new ArrayList();
            Query q = em.createQuery("SELECT s FROM Student s WHERE s.currentsemesterId.name = :name");
            q.setParameter("name", semesterName);
            studentList = q.getResultList();
            return studentList;
        } finally {
            em.close();
        }
    }

    //7. Find (using JPQL) the total number of students in all semesters.
    public List<Student> getStudentsWithASemester() {
        EntityManager em = emf.createEntityManager();

        try {
            List<Student> studentList = new ArrayList();
            Query q = em.createQuery("SELECT s FROM Student s WHERE s.currentsemesterId IS NOT NULL");
            studentList = q.getResultList();
            return studentList;
        } finally {
            em.close();
        }
    }

    //8. Find (using JPQL) the teacher who teaches the most semesters.  
    public Teacher getTeacherWhoTeachesMostSemesters() {
        EntityManager em = emf.createEntityManager();

        try {
            Query q = em.createQuery("SELECT t FROM Teacher t JOIN t.semesterList s ON s.teacherList.id = t.id GROUP BY t.id ORDER BY count(t.id) DESC");
            q.setMaxResults(1);
            Teacher t = (Teacher) q.getSingleResult();
            return t;
        } finally {
            em.close();
        }
    }

    //9. Often (as in almost always) we don’t want a result that matches an Entity class, but a result that
    //matches a specific customer requirement for a specific request.
    public List<StudentInfo> getStudentInfo() {
        EntityManager em = emf.createEntityManager();
        String qStr = "SELECT NEW mappers.StudentInfo"
                + "(student.firstname, student.lastname, student.id, semester.name, semester.description)"
                + "FROM Student AS student, Semester AS semester WHERE student.currentsemesterId.id = semester.id";
        TypedQuery<StudentInfo> query = em.createQuery(qStr, StudentInfo.class);
        return query.getResultList();
    }
    
    //10. Create a method, similar to the one above, but which returns a single StudentInfo , given students id as sketched below:
    //StudentInfo getStudentInfo(long id)
    public StudentInfo getStudentInfo(long id) {
        EntityManager em = emf.createEntityManager();
        String qStr = "SELECT NEW mappers.StudentInfo"
                + "(student.firstname, student.lastname, student.id, semester.name, semester.description)"
                + "FROM Student AS student, Semester AS semester WHERE student.currentsemesterId.id = semester.id AND student.id = :id";
        TypedQuery<StudentInfo> query = em.createQuery(qStr, StudentInfo.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }
    
}
