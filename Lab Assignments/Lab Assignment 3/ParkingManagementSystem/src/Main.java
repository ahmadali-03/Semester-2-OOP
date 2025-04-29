//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Supervisor supervisor = new Supervisor("Dr. Ayesha", 5);
        ParkingSystem system = ParkingSystem.getInstance("CUI Lahore", supervisor);
        ParkingSystem system2 = ParkingSystem.getInstance("again", supervisor);
        ParkingZone zone1 = new ParkingZone();
        ParkingZone zone2 = new ParkingZone();
        Owner owner1 = new Owner("Ali");
        Owner owner2 = new Owner("Zara");
        Vehicle v1 = new Vehicle("LEB123", "Car", owner1);
        Vehicle v2 = new Vehicle("LEB456", "Bike", owner2);
        Vehicle v3 = new Vehicle("LEB789", "Car", owner1);
        zone1.addVehicle(v1);
        zone1.addVehicle(v2);
        zone2.addVehicle(v3);
        system.addZone(zone1);
        system.addZone(zone2);
        PermitHolder ph1 = new PermitHolder("Sara");
        PermitHolder ph2 = new PermitHolder("Hassan");
        system.addPermitHolder(ph1);
        system.addPermitHolder(ph2);
        System.out.println(system);
    }
}