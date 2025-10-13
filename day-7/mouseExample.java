import java.awt.*;
import java.awt.event.*;

public class mouseExample implements MouseListener{
    Label status;
    Frame frame;

    mouseExample(){
        status = new Label("This is Mouse");
        frame = new Frame("Mouse Listener");
        frame.add(status);
        frame.addMouseListener(this);

        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });


        frame.setSize(500,500);
        frame.setLayout(new FlowLayout());
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        new mouseExample();
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        status.setText("Mouse Clicked");
    }
    @Override
    public void mousePressed(MouseEvent e) {
        status.setText("Mouse Pressed");

    }
    @Override
    public void mouseReleased(MouseEvent e) {
        status.setText("Mouse Realsed");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        status.setText("Mouse Entered");
    }
    @Override
    public void mouseExited(MouseEvent e) {
        status.setText("Mouse Exited");
    }
    
}
