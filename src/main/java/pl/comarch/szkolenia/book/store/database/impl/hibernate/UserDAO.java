package pl.comarch.szkolenia.book.store.database.impl.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import pl.comarch.szkolenia.book.store.database.IUserDAO;
import pl.comarch.szkolenia.book.store.model.User;

import javax.persistence.NoResultException;
import java.util.List;
import java.util.Optional;

@Repository
public class UserDAO implements IUserDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Optional<User> getUserByLogin(String login) {
        Session session = this.sessionFactory.openSession();
        Query<User> query = session.createQuery("FROM pl.comarch.szkolenia.book.store.model.User WHERE login = :login");
        query.setParameter("login", login);
        try {
            User user = query.getSingleResult();
            return Optional.of(user);
        } catch (NoResultException e) {
            return Optional.empty();
        } finally {
            session.close();
        }
    }

    @Override
    public Optional<User> getUserById(int id) {
        Session session = this.sessionFactory.openSession();
        Query<User> query = session.createQuery("FROM pl.comarch.szkolenia.book.store.model.User WHERE id = :id");
        query.setParameter("id", id);
        try {
            User user = query.getSingleResult();
            return Optional.of(user);
        } catch (NoResultException e) {
            return Optional.empty();
        } finally {
            session.close();
        }
    }

    @Override
    public void addUser(User user) {
        user.getAddress().setId(0);
        Session session = this.sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(user);
            tx.commit();
        } catch (Exception e) {
            if(tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }
    }

    @Override
    public void deleteUser(int id) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("DELETE FROM pl.comarch.szkolenia.book.store.model.User WHERE id = :id");
            query.setParameter("id", id);
            query.executeUpdate();
            tx.commit();
        } catch (Exception e) {
            if(tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }
    }

    @Override
    public List<User> getAllUsers() {
        Session session = this.sessionFactory.openSession();
        Query<User> query = session.createQuery("FROM pl.comarch.szkolenia.book.store.model.User");
        List<User> users = query.getResultList();
        session.close();
        return users;
    }
}
