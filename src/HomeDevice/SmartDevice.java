package HomeDevice;

public class SmartDevice {
    private String name;
    private boolean isOn;
    private int powerConsumption;

    public SmartDevice(String name, int powerConsumption) {
        this.name = name;
        this.powerConsumption = powerConsumption;
        this.isOn = false; // devices are off initially
    }

    public void turnOn() {
        isOn = true;
        System.out.println(name + " is now ON.");
    }

    public void turnOff() {
        isOn = false;
        System.out.println(name + " is now OFF.");
    }

    public boolean isDeviceOn() {
        return isOn;
    }

    public int getPowerConsumption() {
        return isOn ? powerConsumption : 0;
    }

    public String getName() {
        return name;
    }
}
