public class Bike extends TwoWheelVehicle{

    public void drive(){

    }

    @Override
    public void play() {
        System.out.println("Bike is playing");
    }

    @Override
    public void pause() {
        System.out.println("Bike is paused");
    }

    @Override
    public void printText(){
        System.out.println("Bike is printing");
    }

    @Override
    public void doIt() {
        System.out.println("Bike is doing");
    }
}
