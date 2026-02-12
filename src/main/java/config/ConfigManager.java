package config;

import java.io.InputStream;
import java.util.Properties;

public class ConfigManager {

    private static final Properties props = new Properties();

    static {
        try (InputStream is = ConfigManager.class.getClassLoader()
                .getResourceAsStream("application.properties")) {

            if (is == null) {
                throw new RuntimeException("application.properties not found in src/main/resources");
            }
            props.load(is);

        } catch (Exception e) {
            throw new RuntimeException("Failed to load configuration", e);
        }
    }

    public static String get(String key) {
        String value = props.getProperty(key);
        if (value == null) throw new RuntimeException("Missing property: " + key);
        return value.trim();
    }
}
