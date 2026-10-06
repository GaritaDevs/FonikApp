package fonik.app.persistence;

import fonik.app.entity.Vocabulary;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.List;

import static org.junit.Assert.*;

public class VocabularyDaoTest {

    VocabularyDao vocabularyDao;

    @BeforeEach
    public void setUp() {

    }

    @Test
    public void getById() {
        vocabularyDao = new VocabularyDao();

        Vocabulary retrievedVocabulary = vocabularyDao.getById(2);

        assertNotNull(retrievedVocabulary);
        assertEquals("Hund", retrievedVocabulary.getGermanWord());
    }

    @Test
    public void insertSuccess() {
        vocabularyDao = new VocabularyDao();

        Vocabulary vocabularyToInsert = new Vocabulary(
                "Baum",
                "tree",
                "der",
                "Bäume",
                vocabularyDao.getById(1).getGermanWord()
        );

        int insertedVocabularyId = vocabularyDao.insert(vocabularyToInsert);

        assertNotEquals(0, insertedVocabularyId);

        Vocabulary insertedVocabulary =
                vocabularyDao.getById(insertedVocabularyId);

        assertEquals("Baum", insertedVocabulary.getGermanWord());
    }

    @Test
    public void update() {
        vocabularyDao = new VocabularyDao();

        Vocabulary vocabulary = vocabularyDao.getById(1);

        vocabulary.setEnglishMeaning("dog");

        vocabularyDao.update(vocabulary);

        Vocabulary updatedVocabulary = vocabularyDao.getById(2);

        assertEquals("dog", updatedVocabulary.getEnglishMeaning());
    }



    @Test
    public void delete() {
        vocabularyDao = new VocabularyDao();

        Vocabulary vocabulary = vocabularyDao.getById(3);

        vocabularyDao.delete(vocabulary);

        assertNull(vocabularyDao.getById(1));
    }

    @Test
    public void getAll() {
        vocabularyDao = new VocabularyDao();

        List<Vocabulary> vocabulary = vocabularyDao.getAll();

        assertEquals(2, vocabulary.size());
    }

    @Test
    public void getByPropertyEqual() {
        vocabularyDao = new VocabularyDao();

        List<Vocabulary> vocabulary =
                vocabularyDao.getByPropertyEqual("germanWord", "Haus");

        assertEquals(1, vocabulary.get(0).getId());
    }

}