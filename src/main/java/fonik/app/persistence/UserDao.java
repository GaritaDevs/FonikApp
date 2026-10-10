package fonik.app.persistence;

import fonik.app.entity.User;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;


import java.util.List;


public class UserDao {

    private final Logger logger = LogManager.getLogger(this.getClass());
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    public User getById(int id) {

        try (Session session = sessionFactory.openSession()) {
            return session.get(User.class, id);
        }
    }

    public List<User> getAll() {

        try (Session session = sessionFactory.openSession()) {

            CriteriaQuery<User> query =
                    session.getCriteriaBuilder()
                            .createQuery(User.class);

            Root<User> root = query.from(User.class);
            query.select(root);

            List<User> users =
                    session.createQuery(query).getResultList();

            logger.debug("Retrieved {} users", users.size());

            return users;
        }
    }

    public void delete(User user) {

        Session session = sessionFactory.openSession();
        org.hibernate.Transaction transaction = session.beginTransaction();

        try {
            session.delete(user);
            transaction.commit();

            logger.debug("Deleted user with ID: {}", user.getId());

        } catch (RuntimeException e) {
            transaction.rollback();
            logger.error("Error deleting user", e);
            throw e;

        } finally {
            session.close();
        }
    }

}

