package com.example.demo.ManyToMany.Demo;

import com.example.demo.ManyToMany.Entity.Course;
import com.example.demo.ManyToMany.Entity.Instructor;
import com.example.demo.ManyToMany.Entity.InstructorDetail;
import com.example.demo.ManyToMany.Entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseAndReviewsDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

            Course course = new Course("Blabla");
            Review review = new Review("Good");
            Review review1 = new Review("Wow");
            Review review2 = new Review("Amazing");

            course.addReview(review);
            course.addReview(review1);
            course.addReview(review2);
            System.out.println("Saving the course");
            System.out.println(course);
            System.out.println(course.getReviewList());

            session.save(course);
            session.getTransaction().commit();

            System.out.println("Done");
        } finally {
            session.close();
            factory.close();
        }


    }
}
