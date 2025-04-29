public class Vehicle {

    private String numberPlate;
    private String type;
    Owner owner;

    public Vehicle(String numberPlate, String type, Owner owner) {
        this.numberPlate = numberPlate;
        this.type = type;
        this.owner = owner;
    }

    //@Override
   // public boolean equals(Object o){


  //  }
    public String getNumberPlate() {
        return numberPlate;
    }

    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }
}
