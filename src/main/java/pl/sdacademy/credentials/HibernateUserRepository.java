package pl.sdacademy.credentials;

import org.hibernate.*;
import org.hibernate.engine.transaction.internal.TransactionImpl;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.time.LocalDate;
import java.util.ArrayList;


public class HibernateUserRepository implements UserRepository {

    private SessionFactory sessionFactory;

    public HibernateUserRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public User readById(int id) {
        Session session = null;
        User user = new User();
        try {
            session = sessionFactory.openSession();
            user = session.get(User.class, id);
        }
//        catch (HibernateException e ){} miejsce do zlapania bledu hibernate ale nie mamy zadnego systemu logowania a catch nie moze byc pusty NIGDY dlatego to komentuje
        finally {
            session.close();
        }
        return user;
    }

    @Override
    public ArrayList<User> readAll() {
        ArrayList<User> userArrayList = new ArrayList<>();
        Session session = null;
        try {
            session = sessionFactory.openSession();

            CriteriaBuilder cb = session.getCriteriaBuilder();  //https://www.baeldung.com/hibernate-select-all
            CriteriaQuery<User> cq = cb.createQuery(User.class);
            Root<User> rootEntry = cq.from(User.class);
            CriteriaQuery<User> allUsers = cq.select(rootEntry);

            TypedQuery<User> allQuery = session.createQuery(allUsers);
            userArrayList = (ArrayList<User>) allQuery.getResultList();

        }
//        catch (HibernateException e){      miejsce do zlapania bledu hibernate ale nie mamy zadnego systemu logowania a catch nie moze byc pusty NIGDY dlatego to komentuje
//
//        }
        finally {
            session.close();
        }


        return userArrayList;
    }


    @Override
    public int create(String firstName, String lastName, LocalDate dateOfBirth, Boolean admin) {
        Session session = null;
        Transaction transaction = null;
        User user = null;

        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            user = new User(firstName, lastName , dateOfBirth,admin);
            session.persist(user);
            session.flush();

            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return user.Id();
    }
//Zaimplementuj metodę update w klasie HibernateUserRepository .
    @Override
    public boolean update(int id, String firstName, String lastName, LocalDate dateOfBirth, Boolean admin) {
        Session session = null;
        Transaction transaction = null;
        User user = null;
        Boolean retValue = false;

       try{
           session = sessionFactory.openSession();
           user = readById(id);
           if (user != null) {
               transaction = session.beginTransaction();
               user.FirstName(firstName);
               user.LastName(lastName);
               user.DateOfBirth(dateOfBirth);
               user.Admin(admin);
               session.update(user);
               transaction.commit();
               retValue = true;
           }

       }

       catch (HibernateException e) {
           if (transaction != null) {
               transaction.rollback();
           }
           retValue = false;
       }

       finally {
           session.close();
       }

        return retValue;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

}
