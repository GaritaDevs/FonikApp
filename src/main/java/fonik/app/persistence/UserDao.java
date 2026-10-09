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

        Session session = sessionFactory.openSession();
        User user = session.get(User.class, id);
        session.close();
        return user;
    }

    public List<User> getAll() {

        Session session = sessionFactory.openSession();
        CriteriaQuery<User> query =
                session.getCriteriaBuilder()
                        .createQuery(User.class);
        Root<User> root = query.from(User.class);

        query.select(root);

        List<User> users =
                session.createQuery(query).getResultList();
        logger.debug("The list of Users entries: {}", users);

        session.close();

        return users;
    }
}

