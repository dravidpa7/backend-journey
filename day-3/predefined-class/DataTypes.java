public class DataTypes {
    public static void main(String[] args) {
        // toOctalString  toHexString

        String s = Integer.toString(122);
        System.out.println(s);              // returns STring object
        
        String x = Integer.toBinaryString(55);
        System.out.println(x);             

        int y = Integer.valueOf(x);     // converts string to int 
        System.out.println(y);          // returns Integer Object

        int z = Integer.parseInt(s);    // string to int
        System.out.println(z);          // returns integer value

        String word = "Hello Worlds!";
        System.out.println(word.equals("Hello"));  // retruns Boolean 

        System.out.println(word.charAt(12));  // retruns charcter based on index

        // we have toCharArray -> we can acccess using INdex
    }    
}
