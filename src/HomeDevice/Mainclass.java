package HomeDevice;
import java.util.Scanner;

public class Mainclass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of devices to add: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        SmartDevice[] allDevices = new SmartDevice[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nDevice " + (i + 1) + ":");
            System.out.print("Enter device type (Light/Fan/AC): ");
            String type = sc.nextLine().trim();
            System.out.print("Enter device name: ");
            String name = sc.nextLine();
            System.out.print("Enter power consumption (in watts): ");
            int power = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (type.toLowerCase()) {
                case "light":
                    allDevices[i] = new Light(name, power);
                    break;
                case "fan":
                    allDevices[i] = new Fan(name, power);
                    break;
                case "ac":
                    allDevices[i] = new Ac(name, power);
                    break;
                default:
                    System.out.println("Invalid type, defaulting to Light.");
                    allDevices[i] = new Light(name, power);
            }
        }

        SmartHomeController controller = new SmartHomeController(allDevices);

        // Menu loop
        while (true) {
            System.out.println("\n--- Smart Home Menu ---");
            System.out.println("1. Turn ON a device");
            System.out.println("2. Turn OFF a device");
            System.out.println("3. Turn ON all devices");
            System.out.println("4. Turn OFF all devices");
            System.out.println("5. Show device status");
            System.out.println("6. Show total power consumption");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");

            String input = sc.nextLine(); // read as String
            int choice;

            try {
                choice = Integer.parseInt(input); // convert to integer
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number between 1-7.");
                continue; // go back to menu
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter device name to turn ON: ");
                    String onName = sc.nextLine();
                    for (SmartDevice d : allDevices) {
                        if (d.getName().equalsIgnoreCase(onName)) {
                            d.turnOn();
                        }
                    }
                    break;
                case 2:
                    System.out.print("Enter device name to turn OFF: ");
                    String offName = sc.nextLine();
                    for (SmartDevice d : allDevices) {
                        if (d.getName().equalsIgnoreCase(offName)) {
                            d.turnOff();
                        }
                    }
                    break;
                case 3:
                    controller.turnOnAll();
                    break;
                case 4:
                    controller.turnOffAll();
                    break;
                case 5:
                    controller.showStatus();
                    break;
                case 6:
                    System.out.println("Total Power: " + controller.getTotalPowerConsumption() + "W");
                    break;
                case 7:
                    System.out.println("Exiting... Goodbye!");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid option! Try again.");
            }
        }
    }
}