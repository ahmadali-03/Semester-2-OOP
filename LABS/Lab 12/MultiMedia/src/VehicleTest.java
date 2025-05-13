
public class VehicleTest {

    public static void main(String[] args) {
        Vehicle vehicles[] = new Vehicle[3];
        vehicles[0] = new Car();
        vehicles[1] = new Truck();
        vehicles[2] = new Bike();

        System.out.println(vehicles[2] instanceof MultiMedia);
        System.out.println(vehicles[2] instanceof Printable);

        Doable d = ()-> System.out.println("Doable\n");
        d.doIt();

        processVehical(vehicles);
        processPrintable(vehicles);
    }

    public static void processVehical(Vehicle[] vehicles) {

        System.out.println("Print by for loop:");
        for (int i = 0; i < vehicles.length; i++) {
            vehicles[i].play();
            vehicles[i].pause();
        }

        System.out.println("Print by for lambda:");
        ProcessVehicle processVehicle = (vehicle) -> {
            for (int i = 0; i < vehicle.length; i++) {
                vehicle[i].play();
                vehicle[i].pause();
            }
        };
        processVehicle.process(vehicles);

    }

    public static void processPrintable(Vehicle[] vehicles) {
        if (vehicles[0] instanceof Printable) {
            for (int i = 0; i < vehicles.length; i++) {
                ((TwoWheelVehicle) vehicles[i]).printText();
            }
        }
    }
}