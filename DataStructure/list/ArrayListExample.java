import java.util.ArrayList;
import java.util.Collections; // we are using This for Sort

public class ArrayListExample{
    public static void main(String[] args) {
        ArrayList<String> cars = new ArrayList<String>();

        // either we can use VAR keyWord used in only JAVA 10
        // var car = new ArrayList<String>();
        cars.add("Volvo");
        cars.add("Ford");
        cars.add("BMW");
        System.out.println(cars);
        cars.add(0,"Benz"); // add using index
        cars.get(1); // access using index
        cars.set(3,"ChangedValue"); 
        // cars.remove(index)
        System.out.println(cars);
        System.out.println(cars.size());

        Collections.sort(cars);  // sort by alphabetical order
        // loop using these concept

        for(int i =0; i< cars.size();i++){
            System.out.println(cars.get(i));
        }
    }
}