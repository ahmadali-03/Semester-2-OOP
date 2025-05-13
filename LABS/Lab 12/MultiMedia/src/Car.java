public class Car extends FourWheelVehicle{

    public void drive(){

    }

    @Override
    public void play() {
        System.out.println("Car is playing");
    }

    @Override
    public void pause() {
        System.out.println("Car is paused");
    }
}
