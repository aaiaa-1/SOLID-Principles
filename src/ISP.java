
//Before applying ISP:

interface PersonNoISP {
    void work();
    void eat();
    void sleep();
}

class ProgrammerNoISP implements PersonNoISP {
    @Override
    public void work() {
        System.out.println("Programmer is working...");
    }

    @Override
    public void eat() {
        System.out.println("Programmer is eating...");
    }

    @Override
    public void sleep() {
        System.out.println("Programmer is sleeping...");
    }
}

class BabyNoISP implements PersonNoISP {
    @Override
    public void work() {
        System.out.println("Baby is working...");
    }

    @Override
    public void eat() {
        System.out.println("Baby is eating...");
    }

    @Override
    public void sleep() {
        System.out.println("Baby is sleeping...");
    }
}
//In the code above, we violate the ISP  because the Worker interface is not segregated into more specific interfaces based on different roles or responsibilities.
// The Programmer classes are forced to implement methods that are not relevant to their specific roles like "eat()" and "sleep()".
// and the baby is forced to "work()"

//    After applying ISP:

interface Worker {
    void work();
}

interface Eater {
    void eat();
}

interface Sleeper {
    void sleep();
}

class Programmer implements Worker {
    @Override
    public void work() {
        System.out.println("Programmer is working...");
    }

}

class Baby implements Eater, Sleeper {

    @Override
    public void eat() {
        System.out.println("Manager is eating...");
    }

    @Override
    public void sleep() {
        System.out.println("Manager is sleeping...");
    }
}
//now in the refactored code, you can choose to implement only the Worker interface in the Programmer class, as it represents the relevant responsibility of the Programmer class.
//and we can only use the eater and sleeper interface in the Baby class