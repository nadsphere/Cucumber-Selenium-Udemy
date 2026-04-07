package Base;

import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class BaseUtil {
    public WebDriver driver;
    public Properties config;

    public BaseUtil() {
        config = new Properties();
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                throw new RuntimeException("Unable to find config.properties in classpath");
            }
            config.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config.properties", e);
        }
    }

    public String getConfig(String key) {
        return config.getProperty(key);
    }

    public String getConfig(String key, String defaultValue) {
        return config.getProperty(key, defaultValue);
    }
}
