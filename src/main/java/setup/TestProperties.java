package setup;

import enums.PropertyFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestProperties {
    Properties currentProperties = new Properties();
    public PropertyFile propertyFile;

    TestProperties(PropertyFile propertyFile) {
        this.propertyFile = propertyFile;
    }

    /**
     * Get properties from properties file
     */
    Properties getCurrentProperties() throws IOException {
        FileInputStream in = new FileInputStream(propertyFile.getPropFile());
        currentProperties.load(in);
        in.close();
        return currentProperties;
    }

    /**
     * Get property value by string key
     *
     * @param propertyKey property key
     * @return property
     * @throws IOException
     */
    protected String getProperty(String propertyKey) throws IOException {
        if (!currentProperties.containsKey(propertyKey)) {
            currentProperties = getCurrentProperties();
        }
        return currentProperties.getProperty(propertyKey, null);
    }
}
