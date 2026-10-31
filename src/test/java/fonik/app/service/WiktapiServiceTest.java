
package fonik.app.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import static org.junit.jupiter.api.Assertions.*;

public class WiktapiServiceTest {

    @Test
    public void testWiktapiJSON() throws Exception {

        Client client = ClientBuilder.newClient();

        try {
            WebTarget target =
                    client.target("https://api.wiktapi.dev/v1/en/word/Hund?lang=de");

            String response = target
                    .request(MediaType.APPLICATION_JSON)
                    .get(String.class);

            assertNotNull(response);
            ObjectMapper mapper = new ObjectMapper();
            Words words = mapper.readValue(response, Words.class);
            assertEquals("Hundd", words.getWord());

            //assertEquals("?????", response  );


        } finally {
            client.close();
        }
    }
}
