package fonik.app.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 * Interface providing default functionality to load properties files.
 */
public interface PropertiesLoader {

    Logger logger = LogManager.getLogger(PropertiesLoader.class);

    default Properties loadProperties(String propertiesFilePath) throws Exception {
        Properties properties = new Properties();
        try (InputStream inputStream = this.getClass().getResourceAsStream(propertiesFilePath)) {
            if (inputStream == null) {
                throw new IOException("Properties file not found at path: " + propertiesFilePath);
            }
            properties.load(inputStream);
        } catch (IOException ioException) {
            logger.error("Cannot load the properties file: " + propertiesFilePath, ioException);
            throw ioException;
        }
        return properties;
    }
}