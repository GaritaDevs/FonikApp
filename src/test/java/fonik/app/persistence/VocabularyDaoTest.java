package fonik.app.persistence;

import fonik.app.entity.Vocabulary;
import org.junit.jupiter.api.BeforeEach;
import org.junit.Test;

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
        Vocabulary vocabulary = vocabularyDao.getById(4);
        vocabulary.setEnglishMeaning("dog");
        vocabularyDao.update(vocabulary);
        Vocabulary updatedVocabulary = vocabularyDao.getById(5);
        assertEquals("dog", updatedVocabulary.getEnglishMeaning());
    }



    @Test
    public void delete() {

    }

    @Test
    public void getAll() {

    }

    @Test
    public void getByPropertyEqual() {

    }

}