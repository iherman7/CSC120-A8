public class Cafe extends Building {
   
    /**
    * Attributes
    */
    private String name;
    private String address;
    private int floors;
    private int nCoffeeOunces;
    private int nSugarPackets;
    private int nCreams;
    private int nCups;
    private boolean hasElevator;
  
    /** Default constructor 
    * @return an instance of Cafe 
    */
    public Cafe() {
        super("<Name Unknown>", "<Address Unknown>", 1);
    }

    /**
    * Overloaded constructor for Cafe with nCups and hasElevator
    * @param name string name of cafe
    * @param address string address of cafe
    * @param floors int number of cafe
    * @param nCups number of cups in the inventory
    * @param hasElevator boolean value
    * @return an instance of Cafe
    */
    public Cafe(String name, String address, int floors, int nCups, boolean hasElevator) {
        super(name, address, floors);
        this.name = name;
        this.address = address;
        this.floors = floors;
        this.nCups = nCups;
        this.hasElevator = hasElevator;
        System.out.println("You have built a cafe: ☕");
    }

    /**
    * Full constructor for Cafe
    * @param name string name of cafe
    * @param address string address of cafe
    * @param floors int number of cafe
    * @param nCoffeeOunces number of coffee ounces in the inventory
    * @param nSugarPackets number of sugar packets in the inventory
    * @param nCreams number of creams in the inventory
    * @param nCups number of cups in the inventory
    * @return an instance of Cafe
    */
    public Cafe(String name, String address, int floors, int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups, boolean hasElevator) {
        super(name, address, floors);
        this.name = name;
        this.address = address;
        this.floors = floors;
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
        this.nCups = nCups;
        this.hasElevator = hasElevator;
        System.out.println("You have built a cafe: ☕");
    }
   
    /**
    * Sells coffee by subtracting materials from the inventory
    * @param size size of coffee 
    * @param nSugarPackets number of sugar packets in the inventory
    * @param nCreams number of creams in the inventory
    */
    public void sellCoffee(int size, int nSugarPackets, int nCreams){
        if (this.nCoffeeOunces > 0 && this.nSugarPackets > 0 && this.nCreams > 0 && this.nCups > 0) {
            this.nCoffeeOunces -= size;
            this.nSugarPackets -= nSugarPackets;
            this.nCreams -= nCreams;
            this.nCups -= 1;
        } else {
            restock(this.nCoffeeOunces, this.nSugarPackets, this.nCreams, this.nCups);
        }
    }
    /**
    * Restocks inventory of coffee supplies
    * @param nCoffeeOunces number of coffee ounces in the inventory
    * @param nSugarPackets number of sugar packets in the inventory
    * @param nCreams number of creams in the inventory
    * @param nCups number of cups in the inventory
    */
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups){
        this.nCoffeeOunces += 20;
        this.nSugarPackets += 20;
        this.nCreams += 20;
        this.nCups += 20;
    }

    /**
     * Print a list of methods for this building
    */
    public void showOptions(){
    System.out.println("Available options at " + this.name + ":\n + sellCoffee() \n + restock()");
    }

    /**
     * Travel between floors, but only one at a time unless the building has an elevator
    * @param floorNum int the floor to travel to
    */
    public void goToFloor(int floorNum){
        if (floorNum != 1) {
            throw new RuntimeException("You cannot navigate between floors in this cafe.");
        }
        System.out.println("You are now on floor #" + floorNum + " of " + this.name);
        this.activeFloor = floorNum;
    }

    /**
    * Main to test methods
    */
    public static void main(String[] args) {
        Cafe myCafe = new Cafe("Compass Cafe", "1 Chapin Way", 3, 3, 3, 3, 3, false);
        // myCafe.sellCoffee(3, 2, 1);
        // myCafe.sellCoffee(4, 3, 0);
        myCafe.showOptions();
        myCafe.enter();
        myCafe.goToFloor(2);
    } 
}