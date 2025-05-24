import java.util.Scanner;

interface Fruits {
    void eat();
}
class Mango implements Fruits {
    public void eat() {
        System.out.println("I am eating a Mango");
    }
}
class Banana implements Fruits {
    public void eat() {
        System.out.println("I am eating a Banana");
    }
}

class iAmEating {
    public void eating(Fruits fruit) {
        fruit.eat();
    }
}

public class interfaces {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Choose your fruit to eat-\n\t Mango or Banana: ");
        String eatFruit = sc.next();
        Fruits eatingMango = new Mango();
        Fruits eatingBanana = new Banana();
        iAmEating instruction = new iAmEating();
        if (eatFruit.equalsIgnoreCase("Mango")) {
            instruction.eating(eatingMango);
        }
        else if (eatFruit.equalsIgnoreCase("Banana")) {
            instruction.eating(eatingBanana);
        }
        sc.close();
    }
}
