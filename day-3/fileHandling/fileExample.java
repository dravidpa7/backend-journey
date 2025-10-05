import java.util.Scanner;
import java.io.File;

public class fileExample {
    public static void main(String[] args) {
        try {
            File f = new File("../Sample.txt");
            Scanner reader = new Scanner(f);
            while (reader.hasNextLine()) {
                System.out.println(reader.nextLine());
            }
            reader.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
