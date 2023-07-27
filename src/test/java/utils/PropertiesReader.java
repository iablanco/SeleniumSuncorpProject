package utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {

    private static FileReader fileReader;
    private static Properties properties;
    public PropertiesReader() throws IOException {
        fileReader = new FileReader("src/test/java/config/config.properties");
    }

    public Properties getProperties() throws IOException {
        if(properties == null) {
            properties = new Properties();
            properties.load(fileReader);
        }

        return properties;
    }
}
