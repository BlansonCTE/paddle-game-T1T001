import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.Color;

public class Paddle {
    // 1. Create a variable that will hold the Y axis of the paddle
    //    remember the paddle needs to have a constant Y axis because it shouldnt move vertically
    int Y = 350;
    // 2. Create a variable to hold the width of the paddle.
    int WIDTH = 100;
    // 3. Create a variable to hold the height of the paddle.
    int HEIGHT = 100;
    // create a variable for current speed
    int x = 0;
    // create a variable for change in paddle velocity
    int xa = 2;

    private Game game;

    public Paddle(Game game){
        this.game = game;
    }

    public void move() {
        if (x + xa > 0 && x + xa < game.getWidth() - WIDTH)
            x = x + xa;
    }

    public void paint(Graphics2D g) {
        g.fillRect(x, Y, WIDTH, HEIGHT);
    }

    public void keyReleased(KeyEvent e) {
        xa = 0;
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP)
            xa = -game.speed;
        if (e.getKeyCode() == KeyEvent.VK_DOWN)
            xa = game.speed;
    }

    public Rectangle getBounds(){
        return new Rectangle(x, Y, WIDTH, HEIGHT);
    }

    public int getTopY(){
        return Y;
    }



}