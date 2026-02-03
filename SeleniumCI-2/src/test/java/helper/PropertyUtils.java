package helper;

import java.io.InputStream;
import java.util.Properties;

public final class PropertyUtils {
    private PropertyUtils() {} // Prevent instantiation

    public static Properties loadProperties(String filePath) {
        Properties props = new Properties();
        try (InputStream input = PropertyUtils.class.getClassLoader().getResourceAsStream(filePath)) {
            if (input == null) {
                throw new RuntimeException("Unable to find " + filePath);
            }
            props.load(input);
        } catch (Exception e) {
            throw new RuntimeException("Failed to load properties", e);
        }
        return props;
    }
}