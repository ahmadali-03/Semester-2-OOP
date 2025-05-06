public class Owner extends Person{

    private String ID;
    private static int count = 0;

    public Owner(String name) {
        super(name);
        ID = String.format("%04d", count++);
    }

}
