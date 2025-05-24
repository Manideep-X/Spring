class Animal {
    public String eat() {
        return "Animal is eating (Parent)";
    }
    public String sleep() {
        return "Animal is sleeping (Parent)";
    }
}

class Dog extends Animal {
    public String eat() {
        return "Dog is eating (Child)";
    }
    public String bark() {
        return "Dog is barking (Child)";
    }
}

public class upAnddownCasting {
    public static void main(String[] args) {

        Animal obj1 = new Dog();    // Upcasting
        obj1 = (Animal) new Dog();  // Same thing as above
        System.out.println(obj1.eat()+" , "+obj1.sleep());

        Dog obj2 = (Dog) obj1;      // Downcasting
        System.out.println(obj2.eat()+" , "+obj2.sleep()+" , "+obj2.bark());

        // Dog obj2 = (Dog) new Animal();   This will not work
    }
}
