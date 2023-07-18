
//Let's consider a scenario where we have a base class called Bird with a fly() method.
// We also have a derived class called Ostrich (autriche) which is a flightless bird.
// Initially, the code violates the Liskov Substitution Principle (LSP), and then we'll refactor it to adhere to the principle.


//Before applying LSP:

class BirdNoLSP {
    public void fly() {
        System.out.println("Flying...");
    }
}

class OstrichNoLSP extends Bird {
    @Override
    public void fly() {
        throw new UnsupportedOperationException("Ostriches cannot fly!");
    }
}

//In the code above, the Bird class has a fly() method that prints "Flying...". However, the Ostrich class overrides the fly() method and throws an exception because ostriches cannot fly.
// This violates the LSP because the Ostrich class does not behave as expected when used interchangeably with the Bird class.


//After applying LSP:

interface Flyable {
    void fly();
}

class Bird implements Flyable {
    public void fly() {
        System.out.println("Flying...");
    }
}

class Ostrich implements Flyable {
    public void fly() {
        System.out.println("Ostriches cannot fly!");
    }
}

//In the refactored code, we introduce an interface called Flyable that declares the fly() method. Both the Bird and Ostrich classes implement the Flyable interface and provide their respective implementations of the fly() method.
//With this refactoring, we adhere to the LSP because the Ostrich class now behaves correctly when used INTERCHANGEABLY with the Bird class. The Bird class implements the fly() method according to its capabilities, while the Ostrich class provides its OWN implementation that appropriately communicates the fact that ostriches cannot fly.
//By using the Flyable interface and implementing it in both classes, we ensure that any code relying on the Flyable interface can work correctly with both Bird and Ostrich objects, regardless of their specific flying capabilities.

//This refactoring respects the LSP by """allowing derived classes to provide their own behavior while honoring the contract specified by the base class or interface"""
