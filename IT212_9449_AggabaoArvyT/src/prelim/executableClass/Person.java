package prelim.executableClass;

import java.util.Objects;

public class Person {
    private String name;

    public Person() {
        name = "";
    } // end of constructor

    public Person(String name) {
        this.name = name;
    } // end of constructor

    public String getName() {
        return name;
    } // end of getName method

    public void setName(String name) {
        this.name = name;
    } // end of setName method


    @Override
    public String toString() {
        return "Name: " + name;
    } // end of toString method

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;

        Person that = (Person) o;

        return Objects.equals(name, that.name);
    } // end of equals method

} // end of Person class
