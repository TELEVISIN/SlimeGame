package spawners;

import java.util.Random;

import com.github.hanyaeger.SlimeGame.SlimeGame;
import com.github.hanyaeger.SlimeGame.entities.SmallSlime;
import com.github.hanyaeger.SlimeGame.entities.SlimeKing;
import com.github.hanyaeger.SlimeGame.entities.rooms.Room;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.EntitySpawner;

public class SlimeSpawner extends EntitySpawner {

	public int numOfEnemies = 10;
	public SlimeGame slimeGame;
	public Room room;
	public int numOfSlimes = 0;
	public boolean spawnKing = false;
	
	private final double sceneWidth;
	private final double sceneHeight;

	/**
	 * Constructor of SlimeSpawner. Creates an object of a slime spawner.
	 * @param sceneWidth
	 * @param sceneHeight
	 * @param roomType
	 */
	public SlimeSpawner(double sceneWidth, double sceneHeight, Room roomType) {
		super(100);
		this.sceneWidth = sceneWidth;
		this.sceneHeight = sceneHeight;
		this.room = roomType;
	}

	/**
	 * Spawns the entities.
	 */
	@Override
	protected void spawnEntities() {
		if (spawnKing) {
			spawn(new SlimeKing(randomLocation(), slimeGame, room));
		} else if (numOfSlimes < numOfEnemies && !spawnKing) {
			spawn(new SmallSlime(randomLocation(), slimeGame, room));
			numOfSlimes += 1;
		}
	}

	/**
	 * Generates a random location on the screen.
	 * @return Returns a random Coordinate2D
	 */
	private Coordinate2D randomLocation() {
		double x = new Random().nextInt((int) sceneWidth);
		double y = new Random().nextInt((int) sceneHeight);
		return new Coordinate2D(x, y);
	}

}
