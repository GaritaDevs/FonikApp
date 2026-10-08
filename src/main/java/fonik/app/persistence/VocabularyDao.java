package fonik.app.persistence;

import fonik.app.entity.Vocabulary;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;

import java.util.List;

public class VocabularyDao {

    private final Logger logger = LogManager.getLogger(this.getClass());
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    /**
     * Get vocabulary by id.
     *
     * @param id vocabulary id
     * @return vocabulary entry
     */
    public Vocabulary getById(int id) {

        Session session = sessionFactory.openSession();
        Vocabulary vocabulary = session.get(Vocabulary.class, id);
        session.close();
        return vocabulary;
    }

    /**
     * Update a vocabulary entry.
     *
     * @param vocabulary vocabulary entry to update
     */
    public void update(Vocabulary vocabulary) {

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.merge(vocabulary);
        transaction.commit();
        session.close();
    }

    /**
     * Insert a new vocabulary entry.
     *
     * @param vocabulary vocabulary entry to insert
     * @return id of the inserted vocabulary entry
     */
    public int insert(Vocabulary vocabulary) {

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(vocabulary);
        transaction.commit();

        int id = vocabulary.getId();
        session.close();
        return id;
    }

    /**
     * Delete a vocabulary entry.
     *
     * @param vocabulary vocabulary entry to delete
     */
    public void delete(Vocabulary vocabulary) {

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(vocabulary);
        transaction.commit();

        session.close();
    }

    /**
     * Return a list of all vocabulary entries.
     *
     * @return all vocabulary entries
     */
    public List<Vocabulary> getAll() {

        Session session = sessionFactory.openSession();
        CriteriaQuery<Vocabulary> query =
                session.getCriteriaBuilder()
                        .createQuery(Vocabulary.class);
        Root<Vocabulary> root = query.from(Vocabulary.class);

        query.select(root);

        List<Vocabulary> vocabulary =
                session.createQuery(query).getResultList();
        logger.debug("The list of vocabulary entriesssss: {}", vocabulary);

        session.close();

        return vocabulary;
    }

    /**
     * Get vocabulary by property using an exact match.
     *
     * Example:
     * getByPropertyEqual("germanWord", "Haus")
     *
     * @param propertyName property to search
     * @param value value to search for
     * @return matching vocabulary entries
     */
    public List<Vocabulary> getByPropertyEqual(
            String propertyName, String value) {

        Session session = sessionFactory.openSession();

        logger.debug(
                "Searching for vocabulary with {} = {}",
                propertyName,
                value
        );

        CriteriaQuery<Vocabulary> query =
                session.getCriteriaBuilder()
                        .createQuery(Vocabulary.class);

        Root<Vocabulary> root = query.from(Vocabulary.class);

        query.select(root)
                .where(
                        session.getCriteriaBuilder()
                                .equal(root.get(propertyName), value)
                );

        List<Vocabulary> vocabulary =
                session.createQuery(query).getResultList();

        session.close();

        return vocabulary;
    }

    /**
     * Get vocabulary by property using a partial match.
     *
     * Example:
     * getByPropertyLike("germanWord", "Ha")
     *
     * @param propertyName property to search
     * @param value value to search for
     * @return matching vocabulary entries
     */
    public List<Vocabulary> getByPropertyLike(
            String propertyName, String value) {

        Session session = sessionFactory.openSession();

        logger.debug(
                "Searching for vocabulary with {} like {}",
                propertyName,
                value
        );

        CriteriaQuery<Vocabulary> query =
                session.getCriteriaBuilder()
                        .createQuery(Vocabulary.class);

        Root<Vocabulary> root = query.from(Vocabulary.class);

        Expression<String> propertyPath = root.get(propertyName);

        query.where(
                session.getCriteriaBuilder()
                        .like(propertyPath, "%" + value + "%")
        );

        List<Vocabulary> vocabulary =
                session.createQuery(query).getResultList();

        session.close();

        return vocabulary;
    }
}