package prelim.executableClass;

public class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + "\n";
    } // end of toString method

    // override the equals method
    @Override
    public boolean equals(Object obj) {
        // check if the object is an instance of Animal
        if (obj instanceof Animal) {
            // cast the object to Animal
            Animal animal = (Animal) obj;
            // check if the name of the animal is equal to the name of the current animal
            if (animal.getName().equals(this.name)) {
                return true;
            } // end of if statement
        } // end of if statement
        return false;
    } // end of equals method
} // end of class Animal
