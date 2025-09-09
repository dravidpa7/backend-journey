import java.util.LinkedHashSet;

public class LinkedHashSetExmaple {
    public static void main(String[] args){
        LinkedHashSet<String> cars = new LinkedHashSet<>();

        cars.add("Volvo");
        cars.add("BMW");
        cars.add("Benz");

        System.out.println(cars);

        // SLightly slower due to tracking compare to HashSet

        // same methods - add contain remove clear 
    }
}
