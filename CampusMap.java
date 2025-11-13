import java.util.ArrayList;

public class CampusMap {

    ArrayList<Building> buildings;

    /* Default constructor, initializes empty ArrayList */
    public CampusMap() {
        buildings = new ArrayList<Building>();
    }

    /**
     * Adds a Building to the map
     * @param b the Building to add
     */
    public void addBuilding(Building b) {
        System.out.println("Adding building...");
        buildings.add(b);
        System.out.println("-->Successfully added " + b.getName() + " to the map.");
    }

    /**
     * Removes a Building from the map
     * @param b the Building to remove
     * @return the removed Building
     */
    public Building removeBuilding(Building b) {
        System.out.println("Removing building...");
        buildings.remove(b);
        System.out.println("-->Successfully removed " + b.getName() + " to the map.");
        return b;
    }

    public String toString() {
        String mapString = "DIRECTORY of BUILDINGS";

        for (int i = 0; i < this.buildings.size(); i ++) {
            mapString += "\n  " + (i+1) + ". "+ this.buildings.get(i).getName() + " (" + this.buildings.get(i).getAddress() + ")";
        }
        return mapString;
    }

    public static void main(String[] args) {
        CampusMap myMap = new CampusMap();
        myMap.addBuilding(new Building("Ford Hall", "100 Green Street Northampton, MA 01063", 4));
        myMap.addBuilding(new Building("Bass Hall", "4 Tyler Court Northampton, MA 01063", 4));

        myMap.addBuilding(new House("Cushing House", "1 Mandelle Road", 4, false, false));
        myMap.addBuilding(new House("Comstock House", "2 Mandelle Road", 4, false, true));
        myMap.addBuilding(new House("Gillett House", "47 Elm St", 5, true, true));
        myMap.addBuilding(new House("Emerson House", "1 Paradise Road", 4, false, false));
        myMap.addBuilding(new House("King House", "1 Elm St", 4, true, true));
        myMap.addBuilding(new Cafe("Compass Cafe", "1 Chapin Way", 1, 20, false));
        myMap.addBuilding(new Cafe("Campus Center Cafe", "10 Elm St", 1, 3, 3, 3, 3, false));
        myMap.addBuilding(new Library("Neilson Library", "12 Chapin Way", 4, true));
        myMap.addBuilding(new Library("Josten Library", "1 Green St", 2, false));
        myMap.addBuilding(new Library("Hillyer Library", "20 Elm St", 2, true));

        System.out.println(myMap);

        
        CampusMap newMap = new CampusMap(); // new map to demonstrate overloaded methods

        newMap.addBuilding(new House()); // default constructor
        newMap.addBuilding(new House("Cutter House", "23 Elm St", 3, true)); // overloaded partial constructor
        newMap.addBuilding(new Cafe()); // default constructor
        newMap.addBuilding(new Cafe("Compass Cafe", "1 Chapin Way", 1, 30, false)); // overloaded partial constructor
        newMap.addBuilding(new Library()); // default constructor

        System.out.println(newMap);

        // demonstrate overloaded method returnBook in Library
        Library Hillyer = new Library("Hillyer Library", "20 Elm St", 2, true); 
        Hillyer.addTitle("CSC110 by Unknown");
        Hillyer.addTitle("CSC120 by Unknown");
        Hillyer.checkOut("CSC110 by Unknown");
        Hillyer.checkOut("CSC120 by Unknown");
        Hillyer.returnBook("CSC110 by Unknown", "CSC120 by Unknown"); // overloaded method allows two books to be returned at once
        System.out.println(Hillyer.isAvailable("CSC110 by Unknown"));
        System.out.println(Hillyer.isAvailable("CSC120 by Unknown")); // showing that the books have been returned and are now available

    }
    
}
