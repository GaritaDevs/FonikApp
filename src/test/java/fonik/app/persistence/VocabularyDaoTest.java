package fonik.app.persistence;

import fonik.app.entity.Vocabulary;
import fonik.app.util.Database;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class VocabularyDaoTest {

    VocabularyDao vocabularyDao;

    @BeforeEach
    public void setUp() {
        Database database = Database.getInstance();
        database.runSQL("cleanDB.sql");
    }

    @Test
    public void getById() {

        vocabularyDao = new VocabularyDao();
        Vocabulary vocabulary = vocabularyDao.getById(4);

        assertNotNull(vocabulary);
        assertEquals(4, vocabulary.getId());

    }

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

    @Test
    public void update() {

        vocabularyDao = new VocabularyDao();
        Vocabulary vocabulary = vocabularyDao.getById(5);
        vocabulary.setEnglishMeaning("dog");
        vocabularyDao.update(vocabulary);
        Vocabulary updatedVocabulary = vocabularyDao.getById(5);
        assertEquals("dog", updatedVocabulary.getEnglishMeaning());
    }



    @Test
    public void delete() {

        vocabularyDao = new VocabularyDao();
        Vocabulary vocabulary = vocabularyDao.getById(5);
        vocabularyDao.delete(vocabulary);
        assertNull(vocabularyDao.getById(5));

    }

    @Test
    public void getAll() {
        vocabularyDao = new VocabularyDao();
        List<Vocabulary> vocabulary = vocabularyDao.getAll();
        assertEquals(3, vocabulary.size());
    }

    @Test
    public void getByPropertyEqual() {

        vocabularyDao = new VocabularyDao();
        List<Vocabulary> users = vocabularyDao.getByPropertyEqual(
                "germanWord",
                "Haus"
        );
        assertEquals(4, users.get(0).getId());

    }

    @Test
    void getByPropertyLike() {
        vocabularyDao = new VocabularyDao();
        List<Vocabulary> vocabularies = vocabularyDao.getByPropertyLike("germanWord", "H");
        assertEquals(2, vocabularies.size());
    }

}