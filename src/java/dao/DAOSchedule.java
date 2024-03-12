package dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojo.NewHibernateUtil;
import pojo.Schedule;

public class DAOSchedule {

    public void addSchedule(Schedule schedule) {
        Transaction trans = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            session.save(schedule);
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

    public void deleteSchedule(int idSchedule) {
        Transaction trans = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            Schedule schedule = (Schedule) session.get(Schedule.class, idSchedule);
            if (schedule != null) {
                session.delete(schedule);
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

    public Schedule getScheduleByID(int idSchedule) {
        Schedule schedule = null;
        Transaction trans = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            schedule = (Schedule) session.get(Schedule.class, idSchedule);
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (trans != null) {
                trans.rollback();
            }
        } finally {
            session.close();
        }
        return schedule;
    }

    public List<Schedule> retrieveAllSchedules() {
    List<Schedule> schedules = new ArrayList<>();
    Transaction trans = null;
    Session session = NewHibernateUtil.getSessionFactory().openSession();
    try {
        trans = session.beginTransaction();
        Query query = session.createQuery("from Schedule");
        schedules = query.list();
        trans.commit();
    } catch (Exception e) {
        e.printStackTrace();
        if (trans != null) {
            trans.rollback();
        }
    } finally {
        session.close();
    }
    return schedules;
}


    public void updateSchedule(Schedule schedule) {
        Transaction trans = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            session.update(schedule);
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
    
    public List<Schedule> getAllSchedules() {
        List<Schedule> schedules = null;
        Transaction trans = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            Query query = session.createQuery("from Schedule");
            schedules = query.list();
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (trans != null) {
                trans.rollback();
            }
        } finally {
            session.close();
        }
        return schedules;
    }

   public Schedule getScheduleById(int scheduleId) {
    Transaction trans = null;
    Session session = NewHibernateUtil.getSessionFactory().openSession();
    Schedule schedule = null;
    
    try {
        trans = session.beginTransaction();
        Query query = session.createQuery("from Schedule where idSchedule = :scheduleId");
        query.setParameter("scheduleId", scheduleId);
        schedule = (Schedule) query.uniqueResult();
        trans.commit();
    } catch (Exception e) {
        e.printStackTrace();
        if (trans != null) {
            trans.rollback();
        }
    } finally {
        session.close();
    }
    
    return schedule;
}

    
public String getCourseNameByScheduleId(Integer scheduleId) {
    Transaction trans = null;
    Session session = NewHibernateUtil.getSessionFactory().openSession();
    String courseName = null;

    try {
        trans = session.beginTransaction();
        Query scheduleQuery = session.createQuery("select course.className from Schedule schedule where schedule.idSchedule = :scheduleId");
        scheduleQuery.setInteger("scheduleId", scheduleId);
        courseName = (String) scheduleQuery.uniqueResult();
        trans.commit();
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        session.close();
    }

    return courseName;
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

