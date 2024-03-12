package dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojo.NewHibernateUtil;
import pojo.Course;

public class DAOCourse {

    public void addCourse(Course course) {
        Transaction trans = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            session.save(course);
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void deleteCourse(Integer idClass) {
        Transaction trans = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            Course course = (Course) session.load(Course.class, idClass);
            session.delete(course);
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public List<Course> getCourseById(Integer idClass) {
        Transaction trans = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        List<Course> courses = new ArrayList<>();
        try {
            trans = session.beginTransaction();
            Query query = session.createQuery("from Course where idClass = :idClass");
            query.setInteger("idClass", idClass);
            courses = query.list();
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return courses;
    }

    public List<Course> retrieveAllCourses() {
        List<Course> courses = new ArrayList<>();
        Transaction trans = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            Query query = session.createQuery("from Course");
            courses = query.list();
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return courses;
    }

    public void updateCourse(Course course) {
        Transaction trans = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            session.update(course);
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
