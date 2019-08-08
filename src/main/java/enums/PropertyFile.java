package enums;

/**
 * Paths to properties files depending on application type (native/web)
 */
public enum PropertyFile {
    NATIVE("src/test/resources/properties/nativeTest.properties"),
    WEB("src/test/resources/properties/webTest.properties");

    final String propFile;

    PropertyFile(String propFile) {
        this.propFile = propFile;
    }

    public String getPropFile() {
        return propFile.toString();
    }
}
