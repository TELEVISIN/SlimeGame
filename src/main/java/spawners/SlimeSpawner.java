package spawners;

import java.util.Random;

import com.github.hanyaeger.SlimeGame.SlimeGame;
import com.github.hanyaeger.SlimeGame.entities.SmallSlime;
import com.github.hanyaeger.SlimeGame.entities.rooms.Room;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.EntitySpawner;

public class SlimeSpawner extends EntitySpawner {

	public int numOfEnemies = 10;
	public SlimeGame slimeGame;
	public Room room;
	public int numOfSlimes = 0;
	private final double sceneWidth;
	private final double sceneHeight;

	public SlimeSpawner(double sceneWidth, double sceneHeight, Room roomType) {
		super(100);
		this.sceneWidth = sceneWidth;
		this.sceneHeight = sceneHeight;
		this.room = roomType;
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void spawnEntities() {
		// TODO Auto-generated method stub
		if (numOfSlimes < numOfEnemies) {
			spawn(new SmallSlime(randomLocation(), slimeGame, room));
			numOfSlimes += 1;
			System.out.println("ENEMY SPAWNED");
		}
	}
	
	private Coordinate2D randomLocation() {
		double x = new Random().nextInt((int) sceneWidth);
		double y = new Random().nextInt((int) sceneHeight);
		return new Coordinate2D(x, y);
	}

}
