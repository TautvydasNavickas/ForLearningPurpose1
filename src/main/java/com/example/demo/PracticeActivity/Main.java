package com.example.demo.PracticeActivity;

import com.example.demo.Entity.Employee;
import com.example.demo.Entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure()
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();
        try {
            Employee employee = new Employee("Tautvydas","Navickas","Dukterine");
            Employee employee1 = new Employee("Simona","Grybauskaite","Broline");
            Employee employee2 = new Employee("asdsa","asdsad","asdsadas");
            session.beginTransaction();
            System.out.println("saving employee");
            session.save(employee);
            session.save(employee1);
            session.save(employee2);
            session.getTransaction().commit();
            System.out.println("Employee saved");
            System.out.println("\n\n");
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            System.out.println("Getting employee by primary key");
            Employee employee3 = session.get(Employee.class, employee.getId());
            System.out.println(employee3);
            System.out.println("\n\n");
            System.out.println("\n\n");
            System.out.println("Getting employee by query");
            List<Employee> employeeList = session.createQuery("from Employee emp where emp.company='Dukterine'").getResultList();
            System.out.println(employeeList);
            session.getTransaction().commit();
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            session.createQuery("delete from Employee where id=11").executeUpdate();
            session.getTransaction().commit();
            System.out.println("Done");

        } finally {
            sessionFactory.close();
        }
    }
}
