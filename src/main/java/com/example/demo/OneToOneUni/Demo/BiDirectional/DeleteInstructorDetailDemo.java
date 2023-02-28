package com.example.demo.OneToOneUni.Demo.BiDirectional;

import com.example.demo.OneToOneUni.Entity.Instructor;
import com.example.demo.OneToOneUni.Entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteInstructorDetailDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

            Session session = factory.getCurrentSession();

        try {

            session.beginTransaction();
            int id = 5;
            InstructorDetail instructorDetail = session.get(InstructorDetail.class, id);
            System.out.println("Instruction detail" + instructorDetail);
            System.out.println("Instructor" + instructorDetail.getInstructor());

            instructorDetail.getInstructor().setInstructorDetail(null);

            session.delete(instructorDetail);

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
