import java.awt.*;

class Simple extends Frame{
    Simple(){
        Button btn = new Button("Click Me");
        Button btn1 = new Button("Click");

        add(btn);
        add(btn1);
        setLayout(new FlowLayout());
        setVisible(true);
        setSize(100,100);
    }

    public static void main(String[] args) {
        new Simple();
        
    }
}