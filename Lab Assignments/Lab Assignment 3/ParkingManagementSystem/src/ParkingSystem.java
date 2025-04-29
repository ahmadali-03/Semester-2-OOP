import java.util.Arrays;

public class ParkingSystem {

    private String campusName;
    private Supervisor supervisor;
    private ParkingZone zone[] = new ParkingZone[2];
    private PermitHolder holder[] = new PermitHolder[2];
    static int zoneCount = 0;
    static int holderCount = 0;
    static ParkingSystem instance;

    private ParkingSystem(String name, Supervisor supervisor){
        System.out.println("Parking System Created");
    }

    public static ParkingSystem getInstance(String name, Supervisor supervisor){
        if (instance == null)
            instance = new ParkingSystem(name, supervisor);
        else
            System.out.println("ParkingSystem instance already exists, returning existing instance.");
        return instance;
    }

    public void addZone(ParkingZone z){
        zone[zoneCount++] = z;
    }

    public void addPermitHolder(PermitHolder ph){
        this.holder[holderCount++] = ph;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Campus: " + campusName + "\nSupervisor: " + "\nZones: " + Arrays.toString(zone) + "\nPermit Holder: " + Arrays.toString(holder) + "\n");
    return str.toString();
    }
}
