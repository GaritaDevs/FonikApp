package fonik.app.persistence;

import fonik.app.entity.User;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;


import java.util.List;


public class UserDao extends GenericDao<User> {
    public UserDao() {
        super(User.class);
    }

    public int addUser(User user) {
        return insert(user);
    }

    public User getByEmail(String email) {

        try (Session session = sessionFactory.openSession()) {

            return session.createQuery(
                            "FROM User WHERE email = :email", User.class)
                    .setParameter("email", email)
                    .uniqueResult();
        }
    }
}

