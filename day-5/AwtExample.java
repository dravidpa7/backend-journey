import java.awt.*;

class Simple {  //extends Frame
    Simple(){
        // Flow Layout - places are in fixed position

        Frame frame = new Frame();  // optional method

        Label label = new Label("This is a Lable");
        Button btn = new Button("Click Me");

        // manual Layout  
        btn.setBounds(100, 100, 150, 50);

        Button btn1 = new Button("Click");
        // normal input box 
        TextField textField = new TextField("Enter your name");
        // text area
        TextArea textArea = new TextArea("Add descrption");
        // outcome is always string
        Checkbox checkbox = new Checkbox("tick");
        Choice choice = new Choice();
        choice.add("Choice 1");
        choice.add("Choice 2");


        frame.add(btn1);
        frame.add(btn);
        frame.add(label);
        frame.add(textField);
        frame.add(textArea);
        frame.add(checkbox);
        frame.add(choice);

        //frame.setLayout(new FlowLayout());
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setSize(100,100);
        frame.setTitle("App Title");
    }

    public static void main(String[] args) {
        new Simple();
        
    }
}