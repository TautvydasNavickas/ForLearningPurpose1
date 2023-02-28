package com.example.demo.OneToOneUni.Demo.UniDirectional;

import com.example.demo.OneToOneUni.Entity.Instructor;
import com.example.demo.OneToOneUni.Entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();



        try {
            Session session = factory.getCurrentSession();

            Instructor instructor = new Instructor("Tautvydas", "Navickas", "taut.navickas@gmail.com");
            InstructorDetail instructorDetail = new InstructorDetail("manoyoutube", "Lets go");
            Instructor instructor1 = new Instructor("Simona", "Grybauskaite", "simona@gmail.com");
            InstructorDetail instructorDetail1 = new InstructorDetail("youtube", "Blabla");
            instructor.setInstructorDetail(instructorDetail);
            instructor1.setInstructorDetail(instructorDetail1);

            session.beginTransaction();
            session.save(instructor);
            session.getTransaction().commit();

            System.out.println("Done");
        } finally {
            factory.close();
        }


    }
}
