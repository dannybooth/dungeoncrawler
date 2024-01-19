package dungeonCrawler;

public class player {
	String name;
	int health;
	int points;
	player(String name, int health, int points){
		this.name=name;
		this.health=health;
		this.points=points;
	}
	
	int gethealth() {
		return health;
	}
	
	String getname() {
		return name;
	}
	
	int getpoints() {
		return points;
	}
	
	void healthReduce(int reduce)
	{
		health = health - reduce;
	}
	
	void pointsGain(int gain)
	{
		points = points + gain;
	}
}
