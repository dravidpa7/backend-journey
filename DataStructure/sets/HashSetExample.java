import java.util.HashSet;

public class HashSetExample{
    public static void main(String[] args){
        HashSet<String> cars = new HashSet<>();

        cars.add("First");
        cars.add("Second");
        cars.add("Third");
        cars.add("Fourth");
        cars.add("First"); // Duplicate not allowed, this one will printed 
        // output [Second, Third, First, Fourth] order not preserved 

        System.out.println(cars);
        String a = "Second";
        System.out.println(cars.contains(a));
    }
}