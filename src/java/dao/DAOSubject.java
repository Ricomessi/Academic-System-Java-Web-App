package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.Query;
import pojo.NewHibernateUtil;
import pojo.Subject;

import java.util.ArrayList;
import java.util.List;

public class DAOSubject {
    public void addSubject(Subject subject) {
        Transaction trans = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            session.save(subject);
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (trans != null) {
                trans.rollback();
            }
        } finally {
            session.close();
        }
    }

    public void deleteSubject(int idSubject) {
        Transaction trans = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            Subject subject = (Subject) session.get(Subject.class, idSubject);
            if (subject != null) {
                session.delete(subject);
                trans.commit();
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (trans != null) {
                trans.rollback();
            }
        } finally {
            session.close();
        }
    }

    public Subject getSubjectByID(int idSubject) {
        Subject subject = null;
        Transaction trans = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            subject = (Subject) session.get(Subject.class, idSubject);
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (trans != null) {
                trans.rollback();
            }
        } finally {
            session.close();
        }
        return subject;
    }

   public List<Subject> retrieveAllSubjects() {
    Transaction trans = null;
    Session session = NewHibernateUtil.getSessionFactory().openSession();
    List<Subject> subjects = null;

    try {
        trans = session.beginTransaction();

        // Query to retrieve all subjects with additional properties
        Query query = session.createQuery("FROM Subject s JOIN FETCH s.schedule");
        subjects = query.list();

        trans.commit();
    } catch (Exception e) {
        e.printStackTrace();
        if (trans != null) {
            trans.rollback();
        }
    } finally {
        session.close();
    }

    return subjects;
}


     public void updateSubject(Subject subject) {
    Transaction trans = null;
    Session session = NewHibernateUtil.getSessionFactory().openSession();
    try {
        trans = session.beginTransaction();
        session.update(subject);
        trans.commit();
    } catch (Exception e) {
        if (trans != null) {
            trans.rollback();
        }
        e.printStackTrace();
    } finally {
        session.close();
    }
}
     
    public List<Subject> getAllSubjectsForLecturer(int idSubject) {
    Transaction trans = null;
    Session session = NewHibernateUtil.getSessionFactory().openSession();
    List<Subject> subjects = null;

    try {
        trans = session.beginTransaction();

        // Query to retrieve all subjects for a specific idsubject
        Query query = session.createQuery("FROM Subject s WHERE s.idSubject = :idSubject");
        query.setParameter("idSubject", idSubject);
        subjects = query.list();

        trans.commit();
    } catch (Exception e) {
        e.printStackTrace();
        if (trans != null) {
            trans.rollback();
        }
    } finally {
        session.close();
    }

    return subjects;
}


}
