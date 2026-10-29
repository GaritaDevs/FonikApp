package fonik.app.persistence;

import fonik.app.entity.User;
import fonik.app.entity.Vocabulary;
import fonik.app.util.Database;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * The type User dao test.
 */
public class UserDaoTest {

    /**
     * The User dao.
     */
    UserDao userDao;

    /**
     * Sets up.
     */
    @BeforeEach
    public void setUp() {
        Database database = Database.getInstance();
        database.runSQL("cleanDB.sql");
    }

    /**
     * Gets by id.
     */
    @Test
    public void getById() {

        userDao = new UserDao();

        User user = userDao.getById(1);

        assertNotNull(user);
        assertEquals(1, user.getId());
        assertEquals("testuser", user.getUsername());
    }

    /**
     * Add user success.
     */
    @Test
    public void addUserSuccess() {

        userDao = new UserDao();

        User userToAdd = new User("newuser", "newuser@gmail.com");

        int insertedUserId = userDao.addUser(userToAdd);
        assertNotEquals(0, insertedUserId);

        User insertedUser = userDao.getById(insertedUserId);

        assertNotNull(insertedUser);
        assertEquals("newuser", insertedUser.getUsername());
        assertEquals("newuser@gmail.com", insertedUser.getEmail());
    }


    /**
     * Gets all.
     */
    @Test
    public void getAll() {

        userDao = new UserDao();
        List<User> users = userDao.getAll();
        assertEquals(1, users.size());
    }

    /**
     * Delete.
     */
    @Test
    public void delete() {

        userDao = new UserDao();
        User user = userDao.getById(1);
        assertNotNull(user);
        userDao.delete(user);
        assertNull(userDao.getById(1));
    }

    /**
     * Delete user deletes vocabulary.
     */
    @Test
    public void deleteUserDeletesVocabulary() {
        userDao = new UserDao();
        VocabularyDao vocabularyDao = new VocabularyDao();

        int userId = 1;

        User user = userDao.getById(userId);
        assertNotNull(user);


        List<Vocabulary> vocabularyBefore = vocabularyDao.getAll();
        assertTrue(vocabularyBefore.stream()
                .anyMatch(v -> v.getUser().getId() == userId));


        userDao.delete(user);


        assertNull(userDao.getById(userId));


        List<Vocabulary> vocabularyAfter = vocabularyDao.getAll();
        assertFalse(vocabularyAfter.stream()
                .anyMatch(v -> v.getUser().getId() == userId));
    }
}

