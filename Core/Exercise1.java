import java.util.*;

public class Exercise1 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(5, 2, 9, 1, 7, 3);

        Set<Integer> sortedSet = new TreeSet<>(numbers);

        System.out.println("Sorted list of integers:");
        for (int num : sortedSet) {
            System.out.println(num);
        }
    }
}