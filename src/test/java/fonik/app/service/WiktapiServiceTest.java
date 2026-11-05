package fonik.app.service;

import org.junit.jupiter.api.Test;
import fonik.app.entity.Vocabulary;
import static org.junit.jupiter.api.Assertions.*;

public class WiktapiServiceTest {

    @Test
    public void testGetWord() throws Exception {

        WiktapiService service = new WiktapiService();

        Words words = service.getWord("Hund");

        assertNotNull(words);
        assertEquals("Hund", words.getWord());
        assertNotNull(words.getEntries());
        assertFalse(words.getEntries().isEmpty());
    }

    @Test
    public void testGetVocabulary() throws Exception {

        WiktapiService service = new WiktapiService();

        Vocabulary vocabulary = service.getVocabulary("Hund");

        assertNotNull(vocabulary);
        assertEquals("Hund", vocabulary.getGermanWord());
        assertEquals("dog, hound", vocabulary.getEnglishMeaning());
        assertEquals("der", vocabulary.getArticle());
        assertEquals("Hunde", vocabulary.getPlural());
    }
}