import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.Color;

public class Paddle2 {
    // 1. Create a variable that will hold the Y axis of the Paddle2
    //    remember the Paddle2 needs to have a constant Y axis because it shouldnt move vertically
    int Y = 350;
    // 2. Create a variable to hold the width of the Paddle2.
    int WIDTH = 20;
    // 3. Create a variable to hold the height of the Paddle2.
    int HEIGHT = 100;
    // create a variable for current speed
    int x = 950;
    // create a variable for change in Paddle2 velocity
    int xa = 0;

    private Game game;

    public Paddle2(Game game){
        this.game = game;
    }

    public void move() {
        if (Y + xa > 0 && Y + xa < game.getWidth() - WIDTH)
            Y = Y + xa;
    }

    public void paint(Graphics2D g) {
        g.fillRect(x, Y, WIDTH, HEIGHT);
    }

    public void keyReleased(KeyEvent e) {
        xa = 0;
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W)
            xa = -game.speed;
        if (e.getKeyCode() == KeyEvent.VK_S)
            xa = game.speed;
    }

    public Rectangle getBounds(){
        return new Rectangle(x, Y, WIDTH, HEIGHT);
    }

    public int getTopY(){
        return Y;
    }



}