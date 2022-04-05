package spawners;

import java.util.Random;

import com.github.hanyaeger.SlimeGame.SlimeGame;
import com.github.hanyaeger.SlimeGame.entities.SmallSlime;
import com.github.hanyaeger.SlimeGame.entities.rooms.Room;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.EntitySpawner;

public class SlimeSpawner extends EntitySpawner {

	public SlimeGame slimeGame;
	public Room room;
	public int numOfSlimes = 0;
	private final double sceneWidth;
	private final double sceneHeight;

	public SlimeSpawner(double sceneWidth, double sceneHeight) {
		super(100);
		this.sceneWidth = sceneWidth;
		this.sceneHeight = sceneHeight;
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void spawnEntities() {
		// TODO Auto-generated method stub
		if (numOfSlimes < 10) {
			spawn(new SmallSlime(randomLocation(), slimeGame, room));
			numOfSlimes += 1;

			System.out.println("ENEMY SPAWNED");
		}
	}
	
	private Coordinate2D randomLocation() {
		double x = new Random().nextInt((int) sceneWidth);

		System.out.print("X: ");
		System.out.print(x);
		System.out.print(", Y: ");
		System.out.print(sceneHeight / 2);
		System.out.print(", ");

		return new Coordinate2D(x, sceneHeight / 2);
	}

}
