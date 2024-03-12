package dao;

import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojo.NewHibernateUtil;
import pojo.Student;
import pojo.Studentsubject;

public class DAOStudent {

    private Object password;
    public void addStudent(Student student) {
        Transaction trans = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            session.save(student);
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

    public void deleteStudent(int idStudent) {
        Transaction trans = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            Student student = (Student) session.get(Student.class, idStudent);
            if (student != null) {
                session.delete(student);
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

    public Student getStudentByID(int idStudent) {
        Student student = null;
        Transaction trans = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            student = (Student) session.get(Student.class, idStudent);
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (trans != null) {
                trans.rollback();
            }
        } finally {
            session.close();
        }
        return student;
    }

    public List<Student> retrieveStudent() {
    List<Student> students = new ArrayList<>();
    Transaction trans = null;
    Session session = NewHibernateUtil.getSessionFactory().openSession();
    try {
        trans = session.beginTransaction();
        Query query = session.createQuery("from Student"); // Ubah kueri ini untuk hanya mengambil data mahasiswa
        students = query.list();
        trans.commit();
    } catch (Exception e) {
        e.printStackTrace();
        if (trans != null) {
            trans.rollback();
        }
    } finally {
        session.close();
    }
    return students;
}


    public void updateStudent(Student student) {
        Transaction trans = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            session.update(student);
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
    
    public Student getStudentByEmail(String email) {
    Transaction trans = null;
    Session session = NewHibernateUtil.getSessionFactory().openSession();
    Student student = null;

    try {
        trans = session.beginTransaction();
        Query query = session.createQuery("from Student where email = :email");
        query.setString("email", email);
        student = (Student) query.uniqueResult();
        trans.commit();
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        session.close();
    }

    return student;
}

public List<Student> login(String email, String password) {
    List<Student> student = new ArrayList();
   
    Transaction trans = null;
    Session session = NewHibernateUtil.getSessionFactory().openSession();
    try {
        trans = session.beginTransaction();
        Query query = session.createQuery("from Student where email= :email and password= :password");
        query.setString("email", email);
        query.setString("password", password);
        student = query.list();
        
        trans.commit();
    } catch (Exception e) {
        // Handle exceptions
        if (trans != null) {
            trans.rollback();
        }
    } finally {
        session.close();
    }
    return student;
}

public String getCourseNameByStudentEmail(String email) {
    Transaction trans = null;
    Session session = NewHibernateUtil.getSessionFactory().openSession();
    String courseName = null;

    try {
        trans = session.beginTransaction();
        Query studentQuery = session.createQuery("select idStudent from Student where email = :email");
        studentQuery.setString("email", email);
        Integer studentId = (Integer) studentQuery.uniqueResult();

        if (studentId != null) {
            Query courseQuery = session.createQuery("select course.className from Course course where course.idClass = :studentId");
            courseQuery.setInteger("studentId", studentId);
            courseName = (String) courseQuery.uniqueResult();
        }

        trans.commit();
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        session.close();
    }

    return courseName;
}


public Student getUserByEmail(String email) {
    Transaction trans = null;
    Session session = NewHibernateUtil.getSessionFactory().openSession();
    Student student = null;

    try {
        trans = session.beginTransaction();
        Query query = session.createQuery("from Student where email = :email");
        query.setString("email", email);
        student = (Student) query.uniqueResult();
        trans.commit();
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        session.close();
    }

    return student;
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

    public int getIdSubjectForStudent(int studentId) {
    Session session = NewHibernateUtil.getSessionFactory().openSession();

    try {
        // Query to retrieve student subjects associated with a specific student by studentId
        Query query = session.createQuery("SELECT ss.subject.idSubject FROM Studentsubject ss WHERE ss.student.idStudent = :studentId");
        query.setParameter("studentId", studentId);
        List<Integer> subjectIds = query.list();

        if (!subjectIds.isEmpty()) {
            // Return the first subject ID associated with the student (you may need to modify this logic as per your requirements)
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
