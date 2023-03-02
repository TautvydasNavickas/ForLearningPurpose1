package com.example.demo.LessonsFrom18to27.EagerVsLazy.Demo;


import com.example.demo.LessonsFrom18to27.EagerVsLazy.Entity.Course;
import com.example.demo.LessonsFrom18to27.EagerVsLazy.Entity.Instructor;
import com.example.demo.LessonsFrom18to27.EagerVsLazy.Entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EagerLazyDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

            int id = 1;
            Instructor instructor = session.get(Instructor.class, id);

            System.out.println("va" + instructor);
            System.out.println("va" + instructor.getCourseList());

            session.getTransaction().commit();
            session.close();

            System.out.println("\nSesion is closed\n");
            System.out.println("va" + instructor.getCourseList());
            System.out.println("Done");
        } finally {
            session.close();
            factory.close();
        }


    }
}
