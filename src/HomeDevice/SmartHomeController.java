package HomeDevice;

public class SmartHomeController {
    private SmartDevice[] devices;

    public SmartHomeController(SmartDevice[] devices) {
        this.devices = devices;
    }

    public void turnOnAll() {
        for (SmartDevice device : devices) {
            device.turnOn();
        }
    }

    public void turnOffAll() {
        for (SmartDevice device : devices) {
            device.turnOff();
        }
    }

    public void showStatus() {
        System.out.println("\nDevice Status:");
        for (SmartDevice device : devices) {
            String status = device.isDeviceOn() ? "ON" : "OFF";
            System.out.println(device.getName() + " - " + status + " - Power: " + device.getPowerConsumption() + "W");
        }
    }

    public int getTotalPowerConsumption() {
        int total = 0;
        for (SmartDevice device : devices) {
            total += device.getPowerConsumption();
        }
        return total;
    }
}
