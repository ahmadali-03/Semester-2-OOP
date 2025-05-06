public class PermitHolder  extends Person{

    private String ID;
    private static int count = 0;
    public PermitHolder(String name) {
        super(name);
        //ID = ++count;
        ID = String.format("%04d", count++);
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
