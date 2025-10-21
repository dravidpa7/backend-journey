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
        int mouseX = e.getX();
        int mouseY = e.getY();
        
        // Calculate the center of the ball
        int ballCenterX = cricleX + cricleRadius;
        int ballCenterY = cricleY + cricleRadius;

        // Calculate the vector from mouse to ball
        double dx = ballCenterX - mouseX;
        double dy = ballCenterY - mouseY;

        // Calculate the distance
        double distance = Math.sqrt(dx * dx + dy * dy);

        // Base speed
        double speed = 40;

        // If the mouse is very close, move faster
        if (distance < cricleRadius * 3) {
            speed *= (1 + (cricleRadius * 3 - distance) / (cricleRadius * 3));
        }

        // Normalize the movement vector and apply speed
        if (distance > 0) {
            dx = (dx / distance) * speed;
            dy = (dy / distance) * speed;
        }

        // Update position
        cricleX += dx;
        cricleY += dy;

        // Keep within window boundaries with smooth boundary behavior
        int windowWidth = getWidth();
        int windowHeight = getHeight();

        // Add boundary repulsion
        if (cricleX < cricleRadius) {
            cricleX += speed * 0.5;
        }
        if (cricleY < cricleRadius) {
            cricleY += speed * 0.5;
        }
        if (cricleX + 2 * cricleRadius > windowWidth - cricleRadius) {
            cricleX -= speed * 0.5;
        }
        if (cricleY + 2 * cricleRadius > windowHeight - cricleRadius) {
            cricleY -= speed * 0.5;
        }

        // Ensure the ball stays within bounds
        cricleX = Math.max(0, Math.min(cricleX, windowWidth - 2 * cricleRadius));
        cricleY = Math.max(0, Math.min(cricleY, windowHeight - 2 * cricleRadius));

        


        // Check if mouse caught the ball
        double distToMouse = Math.sqrt(
            Math.pow(mouseX - (cricleX + cricleRadius), 2) +
            Math.pow(mouseY - (cricleY + cricleRadius), 2)
        );

        if (distToMouse < cricleRadius) {
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
