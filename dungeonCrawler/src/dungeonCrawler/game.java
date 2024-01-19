package dungeonCrawler;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class game {
	
	public static void main(String[] args) {
		
		boolean a = true;
		skeleton skeleton = new skeleton();
		dragon dragon = new dragon();
		goblin goblin = new goblin();
		witch witch = new witch();
		
		//a list of possible monsters that can be in a room
		skeleton[] random = {skeleton, skeleton, skeleton, skeleton, goblin, goblin, goblin, witch, witch, dragon};
		//for generating a new monster
		skeleton[] mons = new skeleton[99];
		//number of monsters in a room
		int count = 0;
		
		Scanner input = new Scanner (System.in);
		System.out.println("What is your name?:");
		
		//creates the players with the inputed name, 0 points and 30 health
		player player = new player(input.next(), 30, 0);
		
		//loops until you say false
		while (a == true)
		{
			//generates a random number
			int x =ThreadLocalRandom.current().nextInt(0, 9 + 1);
			mons[count]=random[x];
			//increases the count for the number of monsters
			count++;
			
			//prints out the number of monsters
			System.out.println("There are "+count+" monsters in the room.");
			
			//asks if the user wants to handle more monsters
			System.out.println(player.getname()+ ", would you be able to handle another monster?(true/false):");
			// checks for an invalid input to prevent an infinite loop
			while (!input.hasNextBoolean()) {
                System.out.println("Invalid input. Please enter true or false:");
                input.next();
            }
			a = input.nextBoolean();
		}
		
		//once you say false
		for (int i=0; i<count; i++)
		{
			//player gets attacked by monster
			System.out.println("(Monster "+ (i + 1) +") A "+mons[i].name()+" attacked "+ player.getname() +" so they lost " + mons[i].strength() +" health.");
			//loses health
			player.healthReduce(mons[i].strength());
			System.out.println("current health: "+ player.gethealth());
			
			//when you run out of health its game over
			if(player.health<=0)
			{
				System.out.println("your health has reached zero resulting in a GAME OVER!");
				i = count;
				a = true;
			}
			else
			{
				//player attacks monster
				System.out.println("(Monster "+ (i + 1) +") "+ player.getname() +" attacks the "+mons[i].name()+" so they gained "+ mons[i].strength()+" points.");
				//gains points
				player.pointsGain(mons[i].strength());
				System.out.println("current points: "+ player.getpoints());
			}
		}

		
		//when all the rounds are over
		if(a == false)
		{
			System.out.println("CONGRATULATIONS "+ player.getname() +", you won!");
			System.out.println("Final score: "+ player.getpoints());
		}
		
	}
}
