public class test2 {
    public static void main(String args[]) {
        StringBuilder sb = new StringBuilder("Hello");
        sb.append(" World"); // Modifies the same object
        sb.delete(5, 6); // "Hello World"
        System.out.println(sb); // Output: Hell World [5][6]
        System.out.println(sb.reverse());

        StringBuffer sb2 = new StringBuffer();
        System.out.println(sb2.capacity());
        sb2.insert(0, "String");
        System.out.println(sb2);
        System.out.println(sb2.capacity());
    }
}
