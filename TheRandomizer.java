package Boris;
import robocode.*;
import java.util.Random;
import java.awt.Color;

// API help : http://robocode.sourceforge.net/docs/robocode/robocode/Robot.html

/**
 * TheRandomizer - a robot by (your name here)
 */
public class TheRandomizer extends Robot
{
	/**
	 * run: TheRandomizer's default behavior
	 */
	public void run() {
		// Initialization of the robot should be put here

		// After trying out your robot, try uncommenting the import at the top,
		// and the next line:

		setColors(Color.red,Color.blue,Color.green); // body,gun,radar

		// Robot main loop
		while(true) {
			// Replace the next 4 lines with any behavior you would like
			ahead(getRandomInt(50,250));
			int gunRotation = getRandomInt(1,360);
			turnGunRight(gunRotation);
			back(getRandomInt(50,250));
			turnGunRight(gunRotation);
		}
	}

	/**
	 * onScannedRobot: What to do when you see another robot
	 */
	public void onScannedRobot(ScannedRobotEvent e) {
		turnGunRight(getHeading() - getGunHeading() + e.getBearing());
		fire(Math.min(400 / e.getDistance(), 3));
	}

	/**
	 * onHitByBullet: What to do when you're hit by a bullet
	 */
	public void onHitByBullet(HitByBulletEvent e) {
		// Replace the next line with any behavior you would like
		turnLeft(getRandomInt(90,270));
		ahead(getRandomInt(50,300));
	}
	
	/**
	 * onHitWall: What to do when you hit a wall
	 */
	public void onHitWall(HitWallEvent e) {
		turnLeft(getRandomInt(90,270));
		back(getRandomInt(50,300));
	}
	
	public int getRandomInt(int min, int max){
		Random rand = new Random();
		int randomNum = rand.nextInt((max - min) + 1) + min;
		return randomNum;
	}
	
}


