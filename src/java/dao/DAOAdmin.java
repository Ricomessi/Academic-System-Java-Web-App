package dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojo.NewHibernateUtil;
import pojo.Admin;

public class DAOAdmin {


    

    public List<Admin> login(String email, String password) {
    List<Admin> admin = new ArrayList();
   
    Transaction trans = null;
    Session session = NewHibernateUtil.getSessionFactory().openSession();
    try {
        trans = session.beginTransaction();
        Query query = session.createQuery("from Admin where email= :email and password= :password");
        query.setString("email", email);
        query.setString("password", password);
        admin = query.list();
        
        trans.commit();
    } catch (Exception e) {
        // Handle exceptions
        if (trans != null) {
            trans.rollback();
        }
    } finally {
        session.close();
    }
    return admin;
}
    
    
}
