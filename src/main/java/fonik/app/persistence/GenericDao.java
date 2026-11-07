package fonik.app.persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class GenericDao<T> {

    protected SessionFactory sessionFactory;
    private Class<T> type;
    private final Logger logger = LogManager.getLogger(this.getClass());

    public GenericDao(Class<T> type) {
        this.type = type;
        sessionFactory = SessionFactoryProvider.getSessionFactory();
    }

    public T getById(int id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(type, id);
        }
    }

    public List<T> getAll() {
        try (Session session = sessionFactory.openSession()) {

            CriteriaQuery<T> query =
                    session.getCriteriaBuilder().createQuery(type);

            Root<T> root = query.from(type);
            query.select(root);

            return session.createQuery(query).getResultList();
        }
    }

    public int insert(T entity) {
        Transaction transaction = null;

        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();

            int id = ((Number) session.save(entity)).intValue();

            transaction.commit();
            logger.debug("Inserted entity with ID: {}", id);

            return id;

        } catch (RuntimeException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            logger.error("Error inserting entity", e);
            throw e;
        }
    }

    public void update(T entity) {
        Transaction transaction = null;

        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();

            session.merge(entity);

            transaction.commit();

        } catch (RuntimeException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            logger.error("Error updating entity", e);
            throw e;
        }
    }

    public void delete(T entity) {
        Transaction transaction = null;

        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();

            session.delete(entity);

            transaction.commit();

        } catch (RuntimeException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            logger.error("Error deleting entity", e);
            throw e;
        }
    }

    public List<T> getByPropertyEqual(String propertyName, String value) {
        try (Session session = sessionFactory.openSession()) {

            CriteriaQuery<T> query =
                    session.getCriteriaBuilder().createQuery(type);

            Root<T> root = query.from(type);

            query.select(root)
                    .where(session.getCriteriaBuilder()
                            .equal(root.get(propertyName), value));

            return session.createQuery(query).getResultList();
        }
    }

    public List<T> getByPropertyLike(String propertyName, String value) {
        try (Session session = sessionFactory.openSession()) {

            CriteriaQuery<T> query =
                    session.getCriteriaBuilder().createQuery(type);

            Root<T> root = query.from(type);

            query.select(root)
                    .where(session.getCriteriaBuilder()
                            .like(root.get(propertyName).as(String.class),
                                    "%" + value + "%"));

            return session.createQuery(query).getResultList();
        }
    }
}