package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PathsProperties {

    private static final String PATH_TO_PROPERTY = "src/test/java/test/resources/selfEducation.properties";

    public static Properties readFile() {
        Properties properties = new Properties();
        try (InputStream input = new FileInputStream(PATH_TO_PROPERTY)) {
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
    public static String getProperty(String str) {
        Properties properties = PathsProperties.readFile();
        return properties.getProperty(str);
    }
}

