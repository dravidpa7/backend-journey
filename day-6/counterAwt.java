import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class counterAwt extends Frame{
    TextField display;
    Button increment,reset;

    counterAwt(){
        display = new TextField("0");
        display.setBounds(50,50, 100,30);

        increment = new Button("Increment");
        increment.setBounds(75,100, 50,20);
        increment.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                int countValue = Integer.parseInt(display.getText());
                display.setText(String.valueOf(++countValue));
            }
        });

        reset = new Button("Reset");
        reset.setBounds(75,120,50,20);
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                display.setText("0");
            }
        });

        add(display);
        add(increment);
        add(reset);

        
        setLayout(null);
        setSize(500,500);
        setTitle("Tally Counter");
        setVisible(true); // needed always to be last place

    }
        
    public static void main(String[] args) {
        new counterAwt();
    }
}
