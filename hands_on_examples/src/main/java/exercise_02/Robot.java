package exercise_02;

import java.awt.Image;
import java.util.Collection;

/**
 * The friendly helpers of the protagonist.
 */
public class Robot extends RebelAllianceMember {

  /*
   * Icon by http://www.artua.com/, retrieved here:
   * http://www.iconarchive.com/show/star-wars-icons-by-artua.html
   */
  private static Image icon = new ImageLoader().loadIcon("robot.png");
  
  private static final int INITIAL_POWER = 15;
  
	private Position position;

	public Robot(Position position) {
		this.position = position;
		setPower(INITIAL_POWER);
	}

	@Override
	public Position getCurrentPosition() {
		return position;
	}
	
	@Override
	public void setPosition(Position position) {
    this.position = position;
	}

	@Override
	public Image getImage() {
		return icon; 
	}

  @Override
  public Position calculateNextPosition(Collection<GameBoardElement> elements) {
    return null;
  }

}
