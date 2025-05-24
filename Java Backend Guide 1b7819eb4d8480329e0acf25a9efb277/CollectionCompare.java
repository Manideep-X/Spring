import java.util.*;

class Fruits implements Comparable<Fruits> {
    float price;
    String name;
    
    public Fruits(String name, float price) {
        this.price = price;
        this.name = name;
    }
    
    @Override
    public int compareTo(Fruits fruit) {
        return this.price>fruit.price? 1:-1;
    }
}

public class CollectionCompare {
    public static void main(String[] args) {

        Comparator<Fruits> com = (fruit1, fruit2) -> fruit1.price>fruit2.price? 1:-1;
        
        Scanner sc = new Scanner(System.in);
        List<Fruits> fruit = new ArrayList<>();
        
        System.out.print("Enter the number of fruits: ");
        int n = sc.nextInt();
        
        System.out.println("Enter details of each fruits <fruit_name price>:");
        for (int j = 0; j < n; j++) {
            System.out.print("\t"+(j+1)+". ");
            fruit.add(new Fruits(sc.next(), sc.nextFloat()));
        }

        // Collections.sort(fruit); // sorts the fruits according to the compareTo method from Comparable interface
        // fruit.sort(null); // alternative to Collections.sort(fruit);

        // Collections.sort(fruit, com); // sorts the fruits according to the compare method from Comparator interface
        fruit.sort(com); // alternative to Collections.sort(fruit, com);

        for (Fruits fruits : fruit)
            System.out.println("["+fruits.name+" : "+fruits.price+"]");
        
        sc.close();
    }
}
