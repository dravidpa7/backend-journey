// This is other possiable way to use from other Files -> In public 

// class form extends Simple{
//     form(){
//         super();
//     }
// }

// public class Awt {
//     public static void main(String[] args) {
//         new form();
//     }    
// }

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;

class Awt extends Frame{
    Awt(){
        
        Label email = new Label("email");
        email.setBounds(50, 130, 100, 30);
        TextField emailText = new TextField("enter email");
        emailText.setBounds(170, 130, 100, 30);


        Label password = new Label("password");
        password.setBounds(50, 170, 100, 30);
        TextField passText = new TextField("enter password");
        passText.setBounds(170, 170, 100, 30);

        Label age = new Label("age");
        age.setBounds(50, 210, 100, 30);
        TextField ageText = new TextField("enter age");
        ageText.setBounds(170, 210, 100, 30);

        Button submit = new Button("Submit");
        submit.setBounds(50, 250, 220, 30);

        // ActionListener submitActionListener = new ActionListener() {
        //     // ActionListener Abstract class method
        //     // ananymos class method
        //     @Override
        //     public void actionPerformed(ActionEvent e) {

        //         System.out.println(emailText.getText());
        //         System.out.println(passText.getText());
        //         System.out.println(ageText.getText());
        //     }
        // };

        ButtonListener buttonListener = new ButtonListener(emailText, passText, ageText);
        submit.addActionListener(buttonListener);


        add(email);
        add(emailText);
        add(password);
        add(passText);
        add(age);
        add(ageText);
        add(submit);

        setLayout(null);
        setVisible(true);
        setSize(500,500);
    }
    public static void main(String[] args) {
        new Awt();
    }
}

// this is for reusablity

class ButtonListener implements ActionListener{
    TextField emailText;
    TextField passText;
    TextField ageText;

    ButtonListener(TextField emailText,TextField passText,TextField ageText){
        this.emailText = emailText;
        this.passText = passText;
        this.ageText = ageText;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        try {
            System.out.println(emailText.getText());
            System.out.println(passText.getText());
            System.out.println(ageText.getText());
            System.out.println("This is Data Stored in a File : Demo.txt");

            File f = new File("./demo.txt");
            FileWriter fw = new FileWriter(f);
            fw.write(emailText.getText());
            fw.write(passText.getText());
            fw.write(ageText.getText());
            fw.close();
        } 
        catch (Exception errorTxt) {
            System.out.println(errorTxt);
        }
        
    }
    
}


