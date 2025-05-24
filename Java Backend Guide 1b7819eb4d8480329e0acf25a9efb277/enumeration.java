import java.util.*;

enum Fruit {
    APPLE(50), BANANA(20), ORANGE(30), MANGO(60), PINEAPPLE;
    private Fruit() {
        price = 40;
    }

    private Fruit(int price) {
        this.price = price;
    }
    
    private int price;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}

public class enumeration {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Choose your fruit to eat-\n\t Mango, Banana, Orange, Apple or Pineapple: ");
        String buyFruit = sc.next();
        switch (buyFruit.toUpperCase()) {
            case "MANGO":
                System.out.println(buyFruit + " : " + Fruit.MANGO.getPrice());
                break;
            case "BANANA":
                System.out.println(buyFruit + " : " + Fruit.BANANA.getPrice());
                break;
            case "APPLE":
                System.out.println(buyFruit + " : " + Fruit.APPLE.getPrice());
                break;
            case "ORANGE":
                System.out.println(buyFruit + " : " + Fruit.ORANGE.getPrice());
                break;
            case "PINEAPPLE":
                System.out.println(buyFruit + " : " + Fruit.PINEAPPLE.getPrice());
                break;
            default:
                System.out.println("All fruits:");
                for (Fruit fruit : Fruit.values()) {
                    System.out.println(fruit + " : " + fruit.getPrice());
                }
        }
        sc.close();
    }
}
