package com.rentalcar.dao.impl;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.rentalcar.dao.UserDao;
import com.rentalcar.entity.User;
import com.rentalcar.util.HibernateUtil;

public class UserDaoImpl implements UserDao{
	 private static UserDaoImpl userDaoImpl = null;
     
	    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	     
	    public int saveUser(User user) {
	        Session session = this.sessionFactory.openSession();
	        
	        Transaction transaction = session.beginTransaction();
	        System.out.println("------------------------------SOno nel save");
	        int id = (int)session.save(user);
	        transaction.commit();
	        session.close();
	         
	        return id;     
	    }
	 
	    public void updateUser(User user) {
	        Session session = this.sessionFactory.openSession();
	        Transaction transaction = session.beginTransaction();
	        session.update(user);
	        transaction.commit();
	        session.close();
	    }
	 
	    public void deleteUser(int id) {
	        Session session = this.sessionFactory.openSession();
	        Transaction transaction = session.beginTransaction();
	        User user = session.get(User.class, id);
	        session.delete(user);
	        transaction.commit();
	        session.close();
	    }
	 
	    public User findUserById(int id) {
	        Session session = this.sessionFactory.openSession();
	        User user = session.get(User.class, id);
	        session.close();
	         
	        return user;
}

	    @SuppressWarnings("unchecked")
	    public List<User> findAllUsers() {
	    
	        Session session = this.sessionFactory.openSession();
	        List<User> userList = session.createCriteria(User.class).list();
	        for(User lib : userList){
	            System.out.println("------------------------------");
	            System.out.println(lib);
	        }
	        session.close();
	         
	        return userList;
	    }
	    
	    public static UserDao getInstance() {
	        if(userDaoImpl == null)
	        	userDaoImpl = new UserDaoImpl();
	    
	        return userDaoImpl;
	    }

}
