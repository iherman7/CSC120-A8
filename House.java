import java.util.ArrayList;

public class House extends Building {

  /**
  * Attributes
  */
  private ArrayList<Student> residents;
  private boolean hasDiningRoom;
  private boolean hasElevator;
  private String name;
  private String address;
  private int floors;

  /**
  * Default constructor for House
  * @return an instance of House
  */
  public House() {
    super("<Name Unknown>", "<Address Unknown>", 1);
    System.out.println("You have built a house: 🏠");
  }

  /**
  * Overloaded constructor for House with name, address, floors, and hasElevator
  * @param name string name of house
  * @param address string address of house
  * @param floors int number of floors 
  * @param hasElevator boolean value
  * @return an instance of House
  */
  public House(String name, String address, int floors, boolean hasElevator) {
    super(name, address, floors);
    this.name = name;
    this.address = address;
    this.floors = floors;
    this.hasElevator = hasElevator;
    System.out.println("You have built a house: 🏠");
  }

  /**
  * Full constructor for House
  * @param name string name of house
  * @param address string address of house
  * @param floors int number of floors
  * @param hasDiningRoom boolean value
  * @param hasElevator boolean value
  * @return an instance of House
  */
  public House(String name, String address, int floors, boolean hasDiningRoom, boolean hasElevator) {
    super(name, address, floors);
    this.name = name;
    this.address = address;
    this.floors = floors;
    this.residents = new ArrayList<>();
    this.hasDiningRoom = hasDiningRoom;
    this.hasElevator = hasElevator;
    System.out.println("You have built a house: 🏠");
  }

  /**
  * Accessor for hasDiningRoom
  * @return this.hasDiningRoom boolean value 
  */
  public boolean hasDiningRoom(){
    return this.hasDiningRoom;
  }

  /**
  * Accessor for nResidents
  * @return this.residents amount of residents in the arraylist
  */
  public int nResidents(){
    return this.residents.size();
  }

  /**
  * Allows a student to move in to a house, unless they already live in the house
  * @param s the student moving in
  * @throws RuntimeException if the student already lives in the house
  */
  public void moveIn(Student s){
    if (this.residents.contains(s)){
      throw new RuntimeException("Student already lives in this house.");
    } else {
      this.residents.add(s);
    }
  }

  /**
  * Allows a student to move out of a house, unless they do not already live in the house
  * @param s the student moving out
  * @throws RuntimeException if the student does not live in the house
  */
  public Student moveOut(Student s){
    if (this.residents.contains(s)){
      this.residents.remove(s);
      return s;
    } else {
      throw new RuntimeException("Student does not live in this house.");
    }
  }

  /**
  * Checks if Student s lives in the house
  * @param s the student 
  * @return boolean value 
  */
  public boolean isResident(Student s){
    if (this.residents.contains(s)){
      return true;
    } else {
      return false;
    }
  }

  /**
  * Print a list of methods for this building
  */
  public void showOptions(){
    System.out.println("Available options at " + this.name + ":\n + moveIn() \n + moveOut() \n + isResident()");
  }

  /**
  * Travel between floors, but only one at a time unless the building has an elevator
  * @param floorNum int the floor to travel to
  */
  public void goToFloor(int floorNum){
    if (this.activeFloor == -1) {
        throw new RuntimeException("You are not inside this Building. Must call enter() before navigating between floors.");
      }
    if (floorNum < 1 || floorNum > this.nFloors) {
        throw new RuntimeException("Invalid floor number. Valid range for this Building is 1-" + this.nFloors +".");
      }
    if (this.hasElevator == false){
      if (Math.abs(this.activeFloor - floorNum) != 1 && this.activeFloor - floorNum != 0){
        throw new RuntimeException("This House does not have an elevator.");
        }
    }
    System.out.println("You are now on floor #" + floorNum + " of " + this.name);
    this.activeFloor = floorNum;
  }
  

  /**
  * Main for testing methods
  */
  public static void main(String[] args) {
    // Student myStudent = new Student("Ingrid Herman", "12345678", 2028);
    House myHouse = new House("Cushing House", "1 Mandelle Road", 4, false, false);
    // myHouse.moveIn(myStudent);
    // System.out.println(myHouse.isResident(myStudent));
    // myHouse.showOptions();
    myHouse.enter();
    myHouse.goToFloor(1);
    myHouse.goToFloor(2);
    myHouse.goToFloor(4);

  }

}