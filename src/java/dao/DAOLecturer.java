package dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojo.NewHibernateUtil;
import pojo.Lecturer;

public class DAOLecturer {

    public void addLecturer(Lecturer lecturer) {
        Transaction trans = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            session.save(lecturer);
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void deleteLecturer(Integer idLecturer) {
        Transaction trans = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            Lecturer lecturer = (Lecturer) session.load(Lecturer.class, idLecturer);
            session.delete(lecturer);
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public Lecturer getLecturerById(Integer idLecturer) {
        Transaction trans = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Lecturer lecturer = null;
        try {
            trans = session.beginTransaction();
            lecturer = (Lecturer) session.get(Lecturer.class, idLecturer);
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return lecturer;
    }

    public List<Lecturer> retrieveLecturers() {
        List<Lecturer> lecturers = new ArrayList<>();
        Transaction trans = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            Query query = session.createQuery("from Lecturer");
            lecturers = query.list();
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return lecturers;
    }

    public void updateLecturer(Lecturer lecturer) {
        Transaction trans = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            session.update(lecturer);
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public Lecturer getLecturerByEmail(String email) {
    Transaction trans = null;
    Session session = NewHibernateUtil.getSessionFactory().openSession();
    Lecturer lecturer = null;

    try {
        trans = session.beginTransaction();
        Query query = session.createQuery("from Lecturer where email = :email");
        query.setString("email", email);
        lecturer = (Lecturer) query.uniqueResult();
        trans.commit();
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        session.close();
    }

    return lecturer;
}

    
       public List<Lecturer> login(String email, String password) {
    List<Lecturer> lecturer = new ArrayList();
   
    Transaction trans = null;
    Session session = NewHibernateUtil.getSessionFactory().openSession();
    try {
        trans = session.beginTransaction();
        Query query = session.createQuery("from Lecturer where email= :email and password= :password");
        query.setString("email", email);
        query.setString("password", password);
        lecturer = query.list();
        
        trans.commit();
    } catch (Exception e) {
        // Handle exceptions
        if (trans != null) {
            trans.rollback();
        }
    } finally {
        session.close();
    }
    return lecturer;
}

        
    public Lecturer getUserByEmail(String email) {
    Transaction trans = null;
    Session session = NewHibernateUtil.getSessionFactory().openSession();
    Lecturer lecturer = null;

    try {
        trans = session.beginTransaction();
        Query query = session.createQuery("from Lecturer where email = :email");
        query.setString("email", email);
        lecturer = (Lecturer) query.uniqueResult();
        trans.commit();
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        session.close();
    }

    return lecturer;
}
    
    public int getIdSubjectForLecturer(int lecturerId) {
    Session session = NewHibernateUtil.getSessionFactory().openSession();

    try {
        // Query to retrieve lecturer subjects associated with a specific lecturer by lecturerId
        Query query = session.createQuery("SELECT ls.subject.idSubject FROM Lecturersubject ls WHERE ls.lecturer.idLecturer = :lecturerId");
        query.setParameter("lecturerId", lecturerId);
        List<Integer> subjectIds = query.list();

        if (!subjectIds.isEmpty()) {
            // Return the first subject ID associated with the lecturer (you may need to modify this logic as per your requirements)
            return subjectIds.get(0);
        }
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        session.close();
    }

    return -1; // Return -1 or another default value if no subject is found
}
    
    public int getIdScheduleForSubject(int idSubject) {
    Transaction trans = null;
    Session session = NewHibernateUtil.getSessionFactory().openSession();
    int idSchedule = -1; // Default value if not found

    try {
        trans = session.beginTransaction();

        // Query to retrieve idschedule for a specific idsubject
        Query query = session.createQuery("SELECT s.idSchedule FROM Subject s WHERE s.idSubject = :idSubject");
        query.setParameter("idSubject", idSubject);

        List<Integer> results = query.list();
        if (!results.isEmpty()) {
            idSchedule = results.get(0); // Assuming there's only one result
        }

        trans.commit();
    } catch (Exception e) {
        e.printStackTrace();
        if (trans != null) {
            trans.rollback();
        }
    } finally {
        session.close();
    }

    return idSchedule;
}

    
    

}
