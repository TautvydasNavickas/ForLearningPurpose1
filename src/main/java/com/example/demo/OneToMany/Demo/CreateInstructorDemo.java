package com.example.demo.OneToMany.Demo;

import com.example.demo.OneToMany.Entity.Course;
import com.example.demo.OneToMany.Entity.Instructor;
import com.example.demo.OneToMany.Entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateInstructorDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

            Instructor instructor = new Instructor("Tautvydas", "Navickas", "taut.navickas@gmail.com");
            InstructorDetail instructorDetail = new InstructorDetail("manoyoutube", "Lets go");
            instructor.setInstructorDetail(instructorDetail);


            session.beginTransaction();
            session.save(instructor);
            session.getTransaction().commit();

            System.out.println("Done");
        } finally {
            session.close();
            factory.close();
        }


    }
}
