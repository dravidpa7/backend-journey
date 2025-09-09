import java.util.LinkedList;

public class LinkedListExample {
    public static void main(String[] args){
        LinkedList<String> alpha = new LinkedList<>();
        alpha.add("A");
        alpha.add("B");
        alpha.add("C");
        alpha.add("D");
        System.out.println(alpha);
        alpha.addFirst("Added First");
        alpha.addLast("Added Last");
        //  getFirst(), getLast() It shows First and Last element without 
        //  using index removeFirst(), removeLast()
        System.out.println(alpha);
    }
}
