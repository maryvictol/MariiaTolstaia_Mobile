package enums;

/*
 * List of devices using for testing
 */
public enum Device {
    DEVICE("4200ef00d3964300"),
    EMULATOR("emulator-5554");

    private final String device;

    Device(String device) {
        this.device = device;
    }

    String getDevice() {
        return device;
    }
}
