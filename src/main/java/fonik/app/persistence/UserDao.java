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


/**
 * The type User dao.
 */
public class UserDao {

    private final Logger logger = LogManager.getLogger(this.getClass());
    /**
     * The Session factory.
     */
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    /**
     * Gets by id.
     *
     * @param id the id
     * @return the by id
     */
    public User getById(int id) {

        try (Session session = sessionFactory.openSession()) {
            return session.get(User.class, id);
        }
    }

    /**
     * Gets all.
     *
     * @return the all
     */
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

    /**
     * Add user int.
     *
     * @param user the user
     * @return the int
     */
    public int addUser(User user) {

        Session session = sessionFactory.openSession();
        org.hibernate.Transaction transaction = session.beginTransaction();

        try {
            session.persist(user);
            transaction.commit();

            logger.debug("Added user with ID: {}", user.getId());

            return user.getId();

        } catch (RuntimeException e) {
            transaction.rollback();
            logger.error("Error adding user", e);
            throw e;

        } finally {
            session.close();
        }
    }

    /**
     * Delete.
     *
     * @param user the user
     */
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

