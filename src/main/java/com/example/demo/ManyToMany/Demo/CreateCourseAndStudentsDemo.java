package com.example.demo.ManyToMany.Demo;


import com.example.demo.ManyToMany.Entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseAndStudentsDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

            Course course = new Course("Nuostabus kursas, kito nerasi");
            session.save(course);

            Student student = new Student("Tautvydas", "Navickas", "manoemail");
            Student student1 = new Student("Simona", "Grybauskaite", "josemail");
            course.addStudent(student);
            course.addStudent(student1);

            session.save(student);
            session.save(student1);
            session.getTransaction().commit();

            System.out.println("Done");
        } finally {
            session.close();
            factory.close();
        }


    }
}
