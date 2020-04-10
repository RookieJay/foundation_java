package pers.jay.foundation.interface_abstract;

public interface Behavior {

    String filed = "filed";

    void eat();

    default void print() {
        System.out.println("This is a default method from Interface Behavior");
    }

}
