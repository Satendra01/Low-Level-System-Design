package com.DesignPatterns.Adapter;

interface EnemyAttacker{
	public void fireWeapon();
	public void driveForward();
	public void assignDriver(String drivername);
}

class EnemyTank implements EnemyAttacker{

	@Override
	public void fireWeapon() {
		System.out.println("Enemy Tank fires weapon");
	}

	@Override
	public void driveForward() {
		System.out.println("Enemy Tank moves");
	}

	@Override
	public void assignDriver(String drivername) {
		System.out.println(drivername + "is driving the tank");
	}
	
}


class EnemyRobot{
	public void smashWithHands()
	{
		System.out.println("Robot smashes with hands");
	}
	public void walkForward()
	{
		System.out.println("Robot walks forward");
	}
	public void reactToHuman(String drivername)
	{
		System.out.println("Robot tramps on "+drivername);
	}
}

class EnemyRobotAdapter implements EnemyAttacker{
	EnemyRobot enemyRobot;
	public EnemyRobotAdapter(EnemyRobot enemyRobot) {
		super();
		this.enemyRobot = enemyRobot;
	}

	@Override
	public void fireWeapon() {
		enemyRobot.smashWithHands();
		
	}

	@Override
	public void driveForward() {
		enemyRobot.walkForward();
		
	}

	@Override
	public void assignDriver(String drivername) {
		enemyRobot.reactToHuman(drivername);
		
	}
	
}
public class Test {
	public static void main(String...args)
	{
		EnemyRobot enemyRobot=new EnemyRobot();
		EnemyAttacker attacker=new EnemyRobotAdapter(enemyRobot);
		attacker.fireWeapon();
		attacker.driveForward();
		attacker.assignDriver("Dave");
	}
}
