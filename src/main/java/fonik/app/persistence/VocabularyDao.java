package fonik.app.persistence;

import fonik.app.entity.Vocabulary;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class VocabularyDao extends GenericDao<Vocabulary> {

    public VocabularyDao() {
        super(Vocabulary.class);
    }

    public List<Vocabulary> getByUserId(int userId) {

        try (Session session = sessionFactory.openSession()) {

            CriteriaQuery<Vocabulary> query =
                    session.getCriteriaBuilder()
                            .createQuery(Vocabulary.class);

            Root<Vocabulary> root = query.from(Vocabulary.class);

            query.select(root)
                    .where(session.getCriteriaBuilder()
                            .equal(root.get("user").get("id"), userId));

            return session.createQuery(query).getResultList();
        }
    }
}