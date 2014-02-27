package exercise_02;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.*;

/**
 * @author: nw.
 */
public abstract class Exercise03Base extends JApplet {

  /* Below some configuration stuff. Ignore for now. If you're bold, you can play around with it a bit. */

  private int fieldSize = 48;

  private int horizontalFields = 18;
  private int verticalFields = 12;

  protected abstract void configureGame();

  protected abstract void makeTurn();

  protected int getHorizontalFields() {
    return horizontalFields;
  }

  protected int getVerticalFields() {
    return verticalFields;
  }

  /**
   * Writes the provided text to the console.
   */
  protected void print(String message) {
    System.out.println(message);
  }


  private JPanel background;

  @Override
  public void init() {
    super.init();

    background = new JPanel() {
      private static final long serialVersionUID = 1L;



      @Override
      public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;

        // Draw tiles
        int counter = 0;
        for (int x = 0; x < horizontalFields; x++) {
          for (int y = 0; y < verticalFields; y++) {
            g2.drawImage(randomTiles.get(counter), x * fieldSize, y * fieldSize, null);
            counter++;
          }
        }

        // Draw game elements
        for (GameBoardElement element : gameboard.getElements()) {

          drawShadowTo(g2, element.getCurrentPosition());
          drawElementTo(g2, element);
        }
      }
    };

    addKeyListenerTo(background);
    add(background);
    configureGame();
    prepareBackgroundTiles();
    setSize(horizontalFields * fieldSize, verticalFields * fieldSize);
  }



  private void drawElementTo(Graphics2D g2, GameBoardElement element) {
    Position p = element.getCurrentPosition();
    g2.drawImage(element.getImage(), p.getX() * fieldSize, p.getY() * fieldSize, null);
  }

  private void drawShadowTo(Graphics2D g2, Position p) {
    g2.drawImage(shadow, p.getX() * fieldSize, p.getY() * fieldSize, null);
  }

  private void addKeyListenerTo(JPanel background) {
    background.addKeyListener(new KeyListener() {

      @Override
      public void keyTyped(KeyEvent e) {}

      @Override
      public void keyReleased(KeyEvent e) {}

      @Override
      public void keyPressed(KeyEvent e) {
        makeTurn();
      }
    });

    background.setFocusable(true);
  }

  /**
   * We create a random arrangement of tiles, but need to use the same arrangement during the whole game.
   */
  private void prepareBackgroundTiles() {
    Random random = new Random();
    Image[] tiles = new Image[]{tile1, tile2, tile3};
    for (int i = 0; i < horizontalFields * verticalFields; i++) {
      randomTiles.add(tiles[random.nextInt(3)]);
    }
  }

  private java.util.List<Image> randomTiles = new ArrayList<Image>();
  private ImageLoader loader = new ImageLoader();
  // Tiles from here: http://opengameart.org/content/lpc-tile-atlas
  private Image tile1 = loader.loadIcon("tile1.png");
  private Image tile2 = loader.loadIcon("tile2.png");
  private Image tile3 = loader.loadIcon("tile3.png");
  private Image shadow = loader.loadIcon("shadow.png");

  private static final long serialVersionUID = 1L;

}
