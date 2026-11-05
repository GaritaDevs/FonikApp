package fonik.app.service;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import fonik.app.entity.Vocabulary;

import com.fasterxml.jackson.databind.ObjectMapper;

public class WiktapiService {

    public Words getWord(String germanWord) throws Exception {

        Client client = ClientBuilder.newClient();

        try {
            WebTarget target = client.target(
                    "https://api.wiktapi.dev/v1/en/word/" + germanWord + "?lang=de"
            );

            String response = target.request(MediaType.APPLICATION_JSON)
                    .get(String.class);

            ObjectMapper mapper = new ObjectMapper();

            return mapper.readValue(response, Words.class);

        } finally {
            client.close();
        }
    }

    public Vocabulary getVocabulary(String germanWord) throws Exception {

        Words words = getWord(germanWord);

        if (words.getEntries() == null || words.getEntries().isEmpty()) {
            return null;
        }

        EntriesItem entry = words.getEntries().get(0);

        if (entry.getSenses() == null || entry.getSenses().isEmpty()) {
            return null;
        }

        SensesItem sense = entry.getSenses().get(0);

        Vocabulary vocabulary = new Vocabulary();

        // German word
        vocabulary.setGermanWord(words.getWord());

        // English meaning
        if (sense.getGlosses() != null && !sense.getGlosses().isEmpty()) {
            vocabulary.setEnglishMeaning(String.join(", ", sense.getGlosses()));
        }

        // Article
        if (sense.getTags() != null) {
            if (sense.getTags().contains("masculine")) {
                vocabulary.setArticle("der");
            } else if (sense.getTags().contains("feminine")) {
                vocabulary.setArticle("die");
            } else if (sense.getTags().contains("neuter")) {
                vocabulary.setArticle("das");
            }
        }

        // Plural
        if (entry.getForms() != null) {
            for (FormsItem form : entry.getForms()) {
                if (form.getTags() != null
                        && form.getTags().contains("plural")
                        && !form.getTags().contains("error-unknown-tag")
                        && !form.getTags().contains("definite")) {

                    vocabulary.setPlural(form.getForm());
                    break;
                }
            }
        }

        return vocabulary;
    }
}