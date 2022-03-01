import java.util.*;
import java.util.stream.Collectors;

public class Q1AB {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("ali","eli","hassan","reza","mamad","jafar","gholi","taghi");
        Map<Integer, List<String>> result = words.stream()
                .collect(Collectors.groupingBy(String::length));
        System.out.println(result);
        System.out.println("********************************");

        for (Map.Entry<Integer, List<String>> r:result.entrySet()){
            System.out.println(r.getKey() + " " +  r.getValue() + " Size: " + r.getValue().size());
        }
    }
}
