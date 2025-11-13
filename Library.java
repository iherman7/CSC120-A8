import java.util.Hashtable;

public class Library extends Building {
  
  /**
  * Attributes
  */
  private String name;
  private String address;
  private int floors;
  private Hashtable<String, Boolean> collection;
  private boolean hasElevator;
  
  /** Default constructor 
  * @return an instance of Library 
  */
  public Library() {
    super("<Name Unknown>", "<Address Unknown>", 1);
  }

  /**
  * Full constructor for Library
  * @param name string name of house
  * @param address string address of house
  * @param floors int number of floors 
  * @param hasElevator boolean value
  * @return an instance of Library
  */
  public Library(String name, String address, int floors, boolean hasElevator) {
    super(name, address, floors);
    this.name = name;
    this.address = address;
    this.floors = floors;
    this.collection = new Hashtable<String, Boolean>();
    this.hasElevator = hasElevator;
    System.out.println("You have built a library: 📖");
  }
  
  /**
  * Adds a title to the collection
  * @param title to be added to the collection
  */
  public void addTitle(String title){
    this.collection.put(title, true);
  }

  /**
  * Removes a title from the collection
  * @param title to be removed
  * @return title after removing it
  */
  public String removeTitle(String title) {
    this.collection.remove(title);
    return title;
  }

  /**
  * Allows a title to be checked out of the collection by changing its value to false
  * @param title to be checked out
  */
  public void checkOut(String title){
    this.collection.replace(title, false);
  }

  /**
  * Allows a title to be returned to the collection by changing its value to true
  * @param title to be returned
  */
  public void returnBook(String title){
    this.collection.replace(title, true);
  }

  /**
  * Overloaded method: allows multiple titles to be returned to the collection by changing their values to true
  * @param title to be returned
  * @param title2 to be returned
  */
  public void returnBook(String title, String title2){
    this.collection.replace(title, true);
    this.collection.replace(title2, true);
  }

  /**
  * Checks if a title is in the collection
  * @param title to be checked
  * @return boolean value
  */
  public boolean containsTitle(String title){
    return(this.collection.contains(title));
  }

  /**
  * Checks if a title is available (if its value is true)
  * @param title to be checked
  * @return boolean value
  */
  public boolean isAvailable(String title){
    return(this.collection.get(title));
  }

  /**
  * Prints the entire collection
  */
  void printCollection(){
    System.out.println(this.collection.toString());
  }

  /**
  * Print a list of methods for this building
  */
  public void showOptions(){
    System.out.println("Available options at " + this.name + ":\n + addTitle() \n + removeTitle() \n + checkOut() \n + returnBook() \n + containsTitle() \n + isAvailable() \n + printCollection()");
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
        throw new RuntimeException("This Library does not have an elevator.");
      }
    }
    System.out.println("You are now on floor #" + floorNum + " of " + this.name);
    this.activeFloor = floorNum;
    }

  /**
  * Main for testing methods
  */
  public static void main(String[] args) {
    Library myLibrary = new Library("Neilson Library", "1 Chapin Way", 4, true);
    myLibrary.addTitle("CSC 120 by Unknown");
    myLibrary.printCollection();
    myLibrary.checkOut("CSC 120 by Unknown");
    myLibrary.printCollection();
    System.out.println(myLibrary.isAvailable("CSC 120 by Unknown"));
    // myLibrary.showOptions();
    // myLibrary.enter();
    // myLibrary.goToFloor(3);
  }
}