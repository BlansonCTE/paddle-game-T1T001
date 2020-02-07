import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Color;

class Ball{
    //initialize ball position and intitial velocity
    int x = 500, y = 0, xa = 1, ya = 1;
    // Creat ball size
    private static final int DIAMETER = 30;
    private Game game;

    public Ball(Game game) {
        this.game = game;
    }

    void moveBall(){
         // hits left wall
         if (x + xa < 0)
             game.gameOver();
         // hits right wall
         if (x + xa > game.getWidth() - DIAMETER)
             game.gameOver();
         // hits top wall
         if (y + ya < 0)
             ya = -game.speed;
         // hits down wall
         if (y + ya > game.getHeight() - DIAMETER)
             xa = game.speed;


        if (collision()) {
              xa *= -game.speed;
              x += 5;
              //game.speed++;
                 
        }

         if (collision2()) {
             xa *= -game.speed;
             x -= 5;
             //game.speed++;
                
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

        private boolean collision2(){
            return game.paddle2.getBounds().intersects(getBounds());

        }
        public Rectangle getBounds(){
            return new Rectangle(x, y, DIAMETER, DIAMETER);
        }
}