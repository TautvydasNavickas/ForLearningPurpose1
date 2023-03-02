package com.example.demo.LessonsFrom18to27.OneToOneUni.Demo.BiDirectional;

import com.example.demo.LessonsFrom18to27.OneToOneUni.Entity.Instructor;
import com.example.demo.LessonsFrom18to27.OneToOneUni.Entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetInstructorDetailDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

            Session session = factory.getCurrentSession();

        try {

            session.beginTransaction();
            int id = 16;
            InstructorDetail instructorDetail = session.get(InstructorDetail.class, id);
            System.out.println("Instruction detail" + instructorDetail);
            System.out.println("Instructor" + instructorDetail.getInstructor());

            session.getTransaction().commit();

            System.out.println("Done");
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        finally {
            session.close();
            factory.close();
        }


    }
}
