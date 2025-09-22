package utils.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public final class LoadProperties {

    private static final Properties environmentSetup = loadProperties("src/main/resources/Environment.properties");
    public static final String URL = environmentSetup.getProperty("URL");
    public static final String BROWSER = environmentSetup.getProperty("Browser");
    public static final String KsaData = environmentSetup.getProperty("KsaData");
    public static final String KuwaitData = environmentSetup.getProperty("KuwaitData");
    public static final String BahrainData = environmentSetup.getProperty("BahrainData");



    private LoadProperties() {
        // Prevent instantiation
    }
    public static Properties loadProperties(String path) {
        Properties pro = new Properties();
        try (FileInputStream stream = new FileInputStream(path)) {
            pro.load(stream);
        } catch (IOException e) {
            System.out.println("Error loading properties file: " + e.getMessage());
        }
        return pro;
    }
    public static String getProperty(String key) {
        return environmentSetup.getProperty(key);
    }
}
