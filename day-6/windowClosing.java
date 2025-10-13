import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
// import java.awt.event.WindowListener;

public class windowClosing extends Frame{

    windowClosing(){
        Button btn = new Button("Window Close");
        add(btn);

        addWindowListener(
            new WindowAdapter() {
                public void windowClosing(WindowEvent e){
                    System.exit(0);
                }
            }
        );
        
        setLayout(new FlowLayout());
        setSize(500,500);
        setVisible(true);
    }


    public static void main(String[] args) {
        new windowClosing();
    }

    // First Method
    // @Override
    // public void windowOpened(WindowEvent e) {
    //     throw new UnsupportedOperationException("Unimplemented method 'windowOpened'");
    // }

    // @Override
    // public void windowClosing(WindowEvent e) {
    //     System.exit(0);
    // }

    // @Override
    // public void windowClosed(WindowEvent e) {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'windowClosed'");
    // }

    // @Override
    // public void windowIconified(WindowEvent e) {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'windowIconified'");
    // }

    // @Override
    // public void windowDeiconified(WindowEvent e) {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'windowDeiconified'");
    // }

    // @Override
    // public void windowActivated(WindowEvent e) {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'windowActivated'");
    // }

    // @Override
    // public void windowDeactivated(WindowEvent e) {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'windowDeactivated'");
    // }
    
}
