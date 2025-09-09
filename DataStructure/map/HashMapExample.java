import java.util.HashMap;

public class HashMapExample {
    public static void main(String[] args){
        HashMap<String,String> cites = new HashMap<>();

        cites.put("A","Madurai");
        cites.put("B","Chenai");
        cites.put("C","Comibatore");
        cites.put("D","Tirupur");

        System.out.println(cites);

        String[] keys = cites.keySet().toArray(new String[0]);

        System.out.println(keys);

        for(int i=0 ; i<keys.length ; i++){
                String key = keys[i];    
                System.out.println(cites.get(key));
        }

        // often we only use for each Loop

    }    
}
