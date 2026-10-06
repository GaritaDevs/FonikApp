package fonik.app.persistence;

import org.hibernate.Session;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class SessionFactoryProviderTest {

    @Test
    public void testSessionFactory() {

        assertNotNull(SessionFactoryProvider.getSessionFactory());

        Session session = SessionFactoryProvider
                .getSessionFactory()
                .openSession();

        assertNotNull(session);

        session.close();
    }
}