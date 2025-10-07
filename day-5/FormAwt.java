// This is other possiable way to use from other Files -> In public 

// class form extends Simple{
//     form(){
//         super();
//     }
// }

// public class FormAwt {
//     public static void main(String[] args) {
//         new form();
//     }    
// }

import java.awt.*;

class Awt extends Frame{
    Awt(){
        

        setLayout(null);
        setVisible(true);
        setSize(1000,1000);
    }
}

public class FormAwt {
    public static void main(String[] args) {
        new Awt();
    }
}
