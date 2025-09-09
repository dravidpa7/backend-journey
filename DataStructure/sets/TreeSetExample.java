import java.util.TreeSet;

public class TreeSetExample {
    public static void main(String[] args) {
        TreeSet<String> order = new TreeSet<>();
        order.add("C");
        order.add("B");
        order.add("A");
        order.add("D");
        order.add("E");
        
        System.out.println(order);

        // order will be preserved a b c d e or if numbers  1 2 3 4 5
        // sorted ( natural order)
        // slower due to sorting compare to HastSet
    }    
}
