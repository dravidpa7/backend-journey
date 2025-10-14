import java.awt.*;
import java.awt.event.*;
import javax.swing.JOptionPane;


class ballGame extends Frame implements MouseMotionListener{
    
    int cricleX =200, cricleY = 200,cricleRadius = 50;  // default Value
    Image ballImage;

    ballGame(){

         ballImage = Toolkit.getDefaultToolkit().getImage("download.png");
        addMouseMotionListener(this);
        setSize(600,700);
        setLayout(null);
        setTitle("Ball Game");
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        setVisible(true);
    }

    public void paint(Graphics g){
        super.paint(g);
        if (ballImage != null) {
            g.drawImage(ballImage, cricleX, cricleY, 2*cricleRadius,2*cricleRadius,this);
            
        } else {
            g.setColor(Color.RED);
            g.fillOval(cricleX, cricleY, 2 * cricleRadius, 2 * cricleRadius);
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        // click and need to move the ball
        throw new UnsupportedOperationException("Unimplemented method 'mouseDragged'");
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();

        int speed = 20; // increase this number to make it harder


        if(x<cricleX + cricleRadius){
            cricleX+= speed;
        }
        if(x>cricleX + cricleRadius){
            cricleX-= speed;
        }
        if(y<cricleY + cricleRadius){
            cricleY+= speed;
        }
        if(y>cricleY + cricleRadius){
            cricleY-=speed;
        }

        // keep within window boundaries
        int windowWidth = getWidth();
        int windowHeight = getHeight();

        if (cricleX < 0) cricleX = 0;
        if (cricleY < 0) cricleY = 0;
        if (cricleX + 2 * cricleRadius > windowWidth)
            cricleX = windowWidth - 2 * cricleRadius;
        if (cricleY + 2 * cricleRadius > windowHeight)
            cricleY = windowHeight - 2 * cricleRadius;

        


        int dx = x - (cricleX + cricleRadius);
        int dy = y - (cricleY + cricleRadius);
        double distance = Math.sqrt(dx * dx + dy * dy);

        if (distance < cricleRadius) {
            JOptionPane.showMessageDialog(this, "Vijay is Yours");
            dispose(); // 🔹 closes the Frame window
            System.exit(0); // 🔹 exits the program completely
        }

        repaint();
    }

    public static void main(String[] args) {
        new ballGame();
    }
    
}
