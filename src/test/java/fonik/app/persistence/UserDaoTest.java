package fonik.app.persistence;

import fonik.app.entity.User;
import fonik.app.util.Database;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserDaoTest {

    UserDao userDao;

    @BeforeEach
    public void setUp() {
        Database database = Database.getInstance();
        database.runSQL("cleanDB.sql");
    }

    @Test
    public void getById() {

        userDao = new UserDao();

        User user = userDao.getById(1);

        assertNotNull(user);
        assertEquals(1, user.getId());
        assertEquals("testuser", user.getUsername());
    }

    @Test
    public void addUserSuccess() {

        userDao = new UserDao();

        User userToAdd = new User("newuser", "password123", "newuser@gmail.com");

        int insertedUserId = userDao.addUser(userToAdd);
        assertNotEquals(0, insertedUserId);

        User insertedUser = userDao.getById(insertedUserId);

        assertNotNull(insertedUser);
        assertEquals("newuser", insertedUser.getUsername());
        assertEquals("newuser@gmail.com", insertedUser.getEmail());
    }


    @Test
    public void getAll() {

        userDao = new UserDao();
        List<User> users = userDao.getAll();
        assertEquals(1, users.size());
    }

    @Test
    public void delete() {

        userDao = new UserDao();
        User user = userDao.getById(3);
        assertNotNull(user);
        userDao.delete(user);
        assertNull(userDao.getById(3));
    }
}

