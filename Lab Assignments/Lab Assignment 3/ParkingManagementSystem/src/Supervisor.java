public class Supervisor  extends Person{

    private int experience;

    public Supervisor(String name, int experience) {
        super(name);
        this.experience = experience;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }
}
