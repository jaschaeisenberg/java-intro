package example_06.alliance;

import java.awt.Image;
import java.util.Collection;

import example_06.gameboard.GameBoardElement;
import example_06.gameboard.Position;
import example_06.utils.ImageLoader;

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

	public Robot(Position position) {
		super(position);
		setPower(INITIAL_POWER);
	}

	@Override
	public Image getImage() {
		return icon;
	}

	@Override
	public Position calculateNextPosition(Collection<GameBoardElement> elements) {
		return getCurrentPosition();
	}

}
