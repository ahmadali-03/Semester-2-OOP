import java.util.Arrays;

public class ParkingZone {

    private String ID = "Z";
    private int count = 1;
    private Vehicle vehicles[] = new Vehicle[5];
    private static int vehicalCount = 0;

    public ParkingZone() {

    }

    public ParkingZone(Vehicle[] vehicles) {
        ID = String.format(ID + count++);
        this.vehicles = vehicles;
    }

    public void addVehicle(Vehicle v){
        if (vehicalCount < 5 )
            vehicles[vehicalCount++] = v;
    }
    @Override
    public String toString() {
        return "ParkingZone{" +
                "ID='" + ID + '\'' +
                ", count=" + count +
                ", vehicles=" + Arrays.toString(vehicles) +
                '}';
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public Vehicle[] getVehicles() {
        return vehicles;
    }

    public void setVehicles(Vehicle vehicles[]) {
        this.vehicles = vehicles;
    }
}
