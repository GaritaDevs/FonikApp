package fonik.app.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Interface providing default functionality to load properties files.
 */
public interface PropertiesLoader {

    default Properties loadProperties(String propertiesFilePath) throws Exception {
        Properties properties = new Properties();
        try (InputStream inputStream = this.getClass().getResourceAsStream(propertiesFilePath)) {
            if (inputStream == null) {
                throw new IOException("Properties file not found at path: " + propertiesFilePath);
            }
            properties.load(inputStream);
        } catch (IOException ioException) {
            System.out.println("PropertiesLoader.loadProperties()...Cannot load the properties file");
            ioException.printStackTrace();
            throw ioException;
        }
        return properties;
    }
}