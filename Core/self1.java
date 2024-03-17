import java.util.*;

public class self1 {
    public static void main(String[] args) {
        System.out.println("Collections in java");

        //Making a normal array first
        System.out.println("Printing the array: ");
        int rand[]={21,69,47,52,99};
        for (int i : rand) {
            System.out.print(i);
            System.out.print(" ");
        }
        
        //Converting the array to arraylist
        ArrayList<Integer> l1=new ArrayList<>();
        for (Integer i : rand) {
            l1.add(i);
        }
        System.out.println("\nPrinting the ArrayList");
        System.out.println(l1);

        //Converting the ArrayList to SortedSet
        SortedSet<Integer> Sortedl1 = new TreeSet<Integer>(l1);
        
        System.out.println("Printing the SortedSet");
        System.out.println(Sortedl1);


    }
}
