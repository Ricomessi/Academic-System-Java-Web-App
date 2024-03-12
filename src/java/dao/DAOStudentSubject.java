package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.Query;
import pojo.NewHibernateUtil;
import pojo.Studentsubject;

import java.util.ArrayList;
import java.util.List;

public class DAOStudentSubject {

    public void addStudentsubject(Studentsubject studentsubject) {
        Transaction trans = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            session.save(studentsubject);
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

    public void deleteStudentsubject(int id) {
        Transaction trans = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            Studentsubject studentsubject = (Studentsubject) session.get(Studentsubject.class, id);
            if (studentsubject != null) {
                session.delete(studentsubject);
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

    public Studentsubject getStudentsubjectById(int id) {
        Studentsubject studentsubject = null;
        Transaction trans = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            studentsubject = (Studentsubject) session.get(Studentsubject.class, id);
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (trans != null) {
                trans.rollback();
            }
        } finally {
            session.close();
        }
        return studentsubject;
    }

    public List<Studentsubject> retrieveStudentsubjects() {
        List<Studentsubject> studentsubjects = new ArrayList<>();
        Transaction trans = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            Query query = session.createQuery("from Studentsubject");
            studentsubjects = query.list();
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return studentsubjects;
    }

    public void updateStudentsubject(Studentsubject studentsubject) {
        Transaction trans = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            session.update(studentsubject);
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
    
    public List<Studentsubject> getStudentSubjectsByStudentId(int studentId) {
    List<Studentsubject> studentSubjects = new ArrayList<>();
    Transaction trans = null;
    Session session = NewHibernateUtil.getSessionFactory().openSession();

    try {
        trans = session.beginTransaction();

        // Query to retrieve student subjects associated with a specific student by studentId
        Query query = session.createQuery("FROM Studentsubject ss WHERE ss.student.idStudent = :studentId");
        query.setParameter("studentId", studentId);
        studentSubjects = query.list();

        trans.commit();
    } catch (Exception e) {
        e.printStackTrace();
        if (trans != null) {
            trans.rollback();
        }
    } finally {
        session.close();
    }

    return studentSubjects;
}

    
    
}
