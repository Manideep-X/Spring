import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamAPI {
    public static void main(String[] args) {
        
        List<Integer> arr = Arrays.asList(43, 23, 11, 67, 42, 0);

        int result = arr.stream()
                            .filter(n -> n>30)
                            .map(n -> n/10)
                            .reduce(0, (c,e) -> c+e);

        System.out.println(result);

        Stream<Integer> values = arr.stream()
                            .filter(n -> n>30)
                            .sorted();
        
        values.forEach(n -> System.out.print(n+", "));
    }
}
