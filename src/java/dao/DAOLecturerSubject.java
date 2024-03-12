package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.Query;
import pojo.NewHibernateUtil;
import pojo.Lecturersubject;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;

public class DAOLecturerSubject {

    public void addLecturerSubject(Lecturersubject lecturerSubject) {
        Transaction trans = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            session.save(lecturerSubject);
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

    public void deleteLecturerSubject(int id) {
        Transaction trans = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            Lecturersubject lecturerSubject = (Lecturersubject) session.get(Lecturersubject.class, id);
            if (lecturerSubject != null) {
                session.delete(lecturerSubject);
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

    public Lecturersubject getLecturerSubjectById(int id) {
        Lecturersubject lecturerSubject = null;
        Transaction trans = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            lecturerSubject = (Lecturersubject) session.get(Lecturersubject.class, id);
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (trans != null) {
                trans.rollback();
            }
        } finally {
            session.close();
        }
        return lecturerSubject;
    }

public List<Lecturersubject> retrieveLecturerSubjects() {
    List<Lecturersubject> lecturerSubjects = new ArrayList<>();
    Transaction trans = null;
    Session session = NewHibernateUtil.getSessionFactory().openSession();
    try {
        trans = session.beginTransaction();
        Query query = session.createQuery("from Lecturersubject");
        lecturerSubjects = query.list();
        trans.commit();
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        session.close();
    }
    return lecturerSubjects;
}

    public void updateLecturerSubject(Lecturersubject lecturerSubject) {
        Transaction trans = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            session.update(lecturerSubject);
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
    
   public List<Lecturersubject> getLecturerSubjectsByLecturerId(int lecturerId) {
    List<Lecturersubject> lecturerSubjects = new ArrayList<>();
    Session session = NewHibernateUtil.getSessionFactory().openSession();

    try {
        // Query to retrieve lecturer subjects associated with a specific lecturer by lecturerId
        Query query = session.createQuery("FROM Lecturersubject ls WHERE ls.lecturer.idLecturer = :lecturerId");
        query.setParameter("lecturerId", lecturerId);
        lecturerSubjects = query.list();
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        session.close();
    }

    return lecturerSubjects;
}
   

}
