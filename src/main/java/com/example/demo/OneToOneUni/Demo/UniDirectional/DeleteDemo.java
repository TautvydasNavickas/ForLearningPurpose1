package com.example.demo.OneToOneUni.Demo.UniDirectional;

import com.example.demo.OneToOneUni.Entity.Instructor;
import com.example.demo.OneToOneUni.Entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();



        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();

            int id = 3;
            Instructor instructor = session.get(Instructor.class, id);
            if (instructor != null) {
                session.delete(instructor);
            }

            session.getTransaction().commit();

            System.out.println("Done");
        } finally {
            factory.close();
        }


    }
}
