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
//
//    @Test
//    public void update() {
//
//    }



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