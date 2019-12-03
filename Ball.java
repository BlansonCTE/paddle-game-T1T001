import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Ball extends JPanel {
    //Initialize ball position
    int x = 0, y = 0, xVelocity = 5, yVelocity = 5;
    int width = 800, height = 800;
    int diameter = 60;

    private void moveBall(){
        if (x > getwidth - diameter)
            xVelocity = 5;
        if (y > getheight - diameter)
            yVelocity = 5;
        if (x > getwidth - diameter)
            xVelocity = -5;
        if (y > getheight - diameter)
            yVelocity = -5;
            // Move ball
            x = x + xVelocity;
            y = y + yVelocity;
    }

    @Override
    public void paint(Graphics g){
        //this clears the screen before reprinting circle at new position
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        //Antialiasing makes the figure smoother
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);

        //Draws the circle at new position with same diameter
        g2d.fillOval(x, y, 60, 60);
    }
    public static void main(String[] args) throws InterruptedException {
        //Name of the window
        JFrame frame = new JFrame("Mini Tennis");
        Ball game = new Ball();
        frame.add(game);
        frame.setSize(game.width, game.height);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        while (true){
            game.moveBall();
            game.repaint();
            // tells the processor that the thread which is being 
            // run must sleep for 10 milliseconds. Bigger the number the slower
            // the game moves
            Thread.sleep(10);
        }
    }
}