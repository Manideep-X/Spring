@FunctionalInterface 
interface Fruits {
    void eat();
}

@FunctionalInterface 
interface Add {
    int addNum(int a, int b);
}

public class Lambda {
    public static void main (String args[]) {

        Fruits fruit = () -> System.out.println("I am eating a Fruit");
        Add addno = (a,b) -> a+b;
        fruit.eat();
        System.out.println(addno.addNum(10, 20));
    }
}
