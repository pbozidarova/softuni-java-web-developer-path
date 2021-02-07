package course.springdata.hibernateintro;

import course.springdata.hibernateintro.entity.Student;
import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Optional;

public class HibernateIntroMain {

    public static void main(String[] args) {
        //Create Hibernate config
        Configuration cfg = new Configuration();
        cfg.configure();

        //Creat SessionFactory
        SessionFactory sf = cfg.buildSessionFactory();

        //Create Session
        Session session = sf.openSession();

        //Persist an entity
        Student student = new Student("Dimitar Pavlov");
        session.beginTransaction();
        session.save(student);
        session.getTransaction().commit();

        //Read entity by Id
        session.beginTransaction();
        session.setHibernateFlushMode(FlushMode.MANUAL);
//        Student result = session.get(Student.class, 1L, LockMode.READ);
        long queryID = 1L;
        Optional<Student> result = session.byId(Student.class).loadOptional(queryID);
        session.getTransaction().commit();
        if(result.isPresent()){
            System.out.printf("Studnet: %s", result.orElseGet(() -> null));
        }else {
            System.out.printf("Student with Id:%d does not exist!%n", queryID);
        }

        //List all students using HQL
        session.beginTransaction();
        session.createQuery("FROM Student ", Student.class)
                .setFirstResult(5)
                .setMaxResults(10)
                .stream().forEach(System.out::println);
        session.getTransaction().commit();

        //---------------------------------
        System.out.println("----------------------------------------");
        //Find and list a student using HQL
        session.beginTransaction();
        session.createQuery("FROM Student WHERE name = :name", Student.class)
                .setParameter("name", "Dimitar Pavlov")
                .stream().forEach(System.out::println);
        session.getTransaction().commit();

        //---------------------------------
        System.out.println("----------------------------------------");
        //Type-safe criteria queries
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Student> query = cb.createQuery(Student.class);
        Root<Student> Student_ = query.from(Student.class);

         query.select(Student_).where(cb.like(Student_.get("name"), "D"));
         session.createQuery(query).getResultStream()
                 .forEach(System.out::println);

        //Close session
        session.close();
    }
}
