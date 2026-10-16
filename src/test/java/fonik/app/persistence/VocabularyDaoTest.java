package fonik.app.persistence;

import fonik.app.entity.Vocabulary;
import fonik.app.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * The type Vocabulary dao test.
 */
public class VocabularyDaoTest {

    /**
     * The Vocabulary dao.
     */
    VocabularyDao vocabularyDao;

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

        vocabularyDao = new VocabularyDao();
        Vocabulary vocabulary = vocabularyDao.getById(4);

        assertNotNull(vocabulary);
        assertEquals(4, vocabulary.getId());

    }

    /**
     * Insert success.
     */
    @Test
    public void insertSuccess() {
        vocabularyDao = new VocabularyDao();

        Vocabulary vocabularyToInsert = new Vocabulary(
                "Baum", "tree", "der", "Bäume",
                vocabularyDao.getById(4).getUser()
        );

        int insertedVocabularyId = vocabularyDao.insert(vocabularyToInsert);
        assertNotEquals(0, insertedVocabularyId);
        Vocabulary insertedVocabulary = vocabularyDao.getById(insertedVocabularyId);
        assertEquals("Baum", insertedVocabulary.getGermanWord());
    }

    /**
     * Update.
     */
    @Test
    public void update() {

        vocabularyDao = new VocabularyDao();
        Vocabulary vocabulary = vocabularyDao.getById(5);
        vocabulary.setEnglishMeaning("dog");
        vocabularyDao.update(vocabulary);
        Vocabulary updatedVocabulary = vocabularyDao.getById(5);
        assertEquals("dog", updatedVocabulary.getEnglishMeaning());
    }


    /**
     * Delete.
     */
    @Test
    public void delete() {

        vocabularyDao = new VocabularyDao();
        Vocabulary vocabulary = vocabularyDao.getById(5);
        vocabularyDao.delete(vocabulary);
        assertNull(vocabularyDao.getById(5));

    }

    /**
     * Delete vocabulary does not delete user.
     */
    @Test
    public void deleteVocabularyDoesNotDeleteUser() {
        vocabularyDao = new VocabularyDao();
        UserDao userDao = new UserDao();


        Vocabulary vocabulary = vocabularyDao.getById(5);
        assertNotNull(vocabulary);


        int userId = vocabulary.getUser().getId();
        vocabularyDao.delete(vocabulary);


        assertNull(vocabularyDao.getById(5));
        assertNotNull(userDao.getById(userId));
    }

    /**
     * Gets all.
     */
    @Test
    public void getAll() {
        vocabularyDao = new VocabularyDao();
        List<Vocabulary> vocabulary = vocabularyDao.getAll();
        assertEquals(3, vocabulary.size());
    }

    /**
     * Gets by property equal.
     */
    @Test
    public void getByPropertyEqual() {

        vocabularyDao = new VocabularyDao();
        List<Vocabulary> users = vocabularyDao.getByPropertyEqual(
                "germanWord",
                "Haus"
        );
        assertEquals(4, users.get(0).getId());

    }

    /**
     * Gets by property like.
     */
    @Test
    void getByPropertyLike() {
        vocabularyDao = new VocabularyDao();
        List<Vocabulary> vocabularies = vocabularyDao.getByPropertyLike("germanWord", "H");
        assertEquals(2, vocabularies.size());
    }

}