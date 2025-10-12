import java.awt.*;
import java.awt.event.ActionListener;

public class calculator extends Frame {
    TextField display;
    Button btn0, btn1, btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn10,plus, minus, multiple,division,equals,clear;
    calculator(){
        display = new TextField("0");
        display.setBounds(50, 50, 400, 50);


        btn0 = new Button("0");
        btn0.setBounds(50,400,80,80);
        // btn0.addActionListener(this);
        
        btn1 = new Button("1");
        btn1.setBounds(50,300,80,80);
        
        btn2 = new Button("2");
        btn2.setBounds(150,300,80,80);
        
        btn3 = new Button("3");
        btn3.setBounds(250,300,80,80);

        btn4 = new Button("4");
        btn4.setBounds(50,200,80,80);
        
        btn5= new Button("5");
        btn5.setBounds(150,200,80,80);

        btn6 = new Button("6");
        btn6.setBounds(250,200,80,80);

        btn7 = new Button("7");
        btn7.setBounds(50,100,80,80);

        btn8 = new Button("8");
        btn8.setBounds(150,100,80,80);

        btn9 = new Button("9");
        btn9.setBounds(250,100,80,80);

        plus = new Button("+");
        plus.setBounds(350,300,80,80);

        minus = new Button("-");
        minus.setBounds(350,200,80,80);

        multiple = new Button("*");
        multiple.setBounds(350,100,80,80);

        division = new Button("/");
        division.setBounds(350,400,80,80);

        equals = new Button("=");
        equals.setBounds(150,400,80,80);
        

        clear = new Button("C");
        clear.setBounds(250,400,80,80);

        add(display);

        Button[] buttons = {btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, plus, minus, multiple, division, equals, clear};
        for (Button b : buttons) {
            add(b);
        }

        setLayout(null);
        setSize(500,800);
        setTitle("Tally Counter");
        setVisible(true);
    }
    public static void main(String[] args) {
        new calculator();
    }
}
