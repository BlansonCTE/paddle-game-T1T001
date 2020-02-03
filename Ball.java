import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Color;

class Ball{
    //initialize ball position and intitial velocity
    int x = 0, y = 0, xa = 1, ya = 1;
    // Creat ball size
    private static final int DIAMETER = 30;
    private Game game;

    public Ball(Game game) {
        this.game = game;
    }

    void moveBall(){
        // hits left wall
        if (x + xa < 0)
            xa = game.speed;
        // hits right wall
        if (x + xa > game.getWidth() - DIAMETER)
            xa = -game.speed;
        // hits top wall
        if (y + ya < 0)
            ya = game.speed;
        // goes under paddle
        else if (y + ya > game.getHeight() - DIAMETER)
            game.gameOver();
        if (collision()) {
            ya = -game.speed;
            y = game.paddle.getTopY() - DIAMETER;
            game.speed++;
            
        }

            // Move ball
            x = x + xa;
            y = y + ya;
        }

        public void paint (Graphics2D g){
            g.setColor(Color.GREEN);
            g.fillOval(x, y, DIAMETER, DIAMETER);
        }
        private boolean collision(){
            return game.paddle.getBounds().intersects(getBounds());

        }
        public Rectangle getBounds(){
            return new Rectangle(x, y, DIAMETER, DIAMETER);
        }
}