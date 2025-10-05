import java.io.File;
import java.io.FileWriter;

public class writingFile {
    public static void main(String[] args) {
        try {
            File f = new File("../Sample.txt");
            FileWriter fw = new FileWriter(f);
            fw.write("Hello Dravid");
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // if we try to write(555) converted into Bit stream show ANother symbol
    // if we need the Nuber to be printed need to use 555 -> "555"
}
