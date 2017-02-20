import java.util.*;
import java.io.*;
import java.lang.*;

public class citysim9004
{
	public static void main (String[] args)
	{
		Location presby = null;
		Location union = null;
		Location sennott = null;
		Location hillman = null;
		Location out = null;
		
		Random rand;
		rand = seedRandom(args);
		
		if (rand == null)
			System.exit(1);
		
		presby = new Location("Presby");
		union = new Location("Union");
		sennott = new Location("Sennott");
		hillman = new Location("Hillman");
		out = new Location("OutsideCity");
		
		Location[] temp1 = {union, sennott};
		Location[] temp2 = {hillman, out};
		Location[] temp3 = {out, presby};
		Location[] temp4 = {sennott, union};
		Location[] temp5 = {union, sennott};
		Location[] locations = {presby, union, sennott, hillman, out};
		
		presby.setConnections(temp1);
		union.setConnections(temp2);
		sennott.setConnections(temp3);
		hillman.setConnections(temp4);
		out.setConnections(null);
		
		for (int i = 1; i < 6; i ++)
		{
			Driver driver = new Driver(rand.nextInt(4), locations);

			while (driver.getCurrentLoc() != out)
			{
				driver.setCurrentLoc(driver.getNextLoc(rand.nextInt(2)));
				System.out.println("Driver " + i + " drives from " + driver.getPreviousLoc().getName() + " to " + driver.getCurrentLoc().getName() + " via " + driver.getRoadLastTravelled(driver.getCurrentLoc(), driver.getPreviousLoc()));
				
				if (driver.getCurrentLoc() == sennott)
					driver.incrementSennCount();				
			}
			
			if (driver.getPreviousLoc().getName().equals("Union"))
				System.out.println("Driver " + i + " heads to Philadelphia!");
			else 
				System.out.println("Driver " + i + " heads to Cleveland!");
			
			System.out.println("Driver " + i + " met with Professor Laboon " + Driver.getSennCount() + " times.");
			if (Driver.getSennCount() >= 3)
				System.out.println("Wow, that driver needed lots of CS help!\n-----");
			else if (Driver.getSennCount() == 0)
				System.out.println("That student missed out!\n-----");
			else
				System.out.println("-----");
		}	
	}
	
	public static Random seedRandom(String[] arguments)
	{
		if (arguments.length != 1)
		{
			System.out.println("You have entered an inappropriate number of arguments! Please follow the execution instructions below.");
			System.out.println("Execution:	java citysim9004 <RandomNumberGeneratorSeed>");
			System.out.println("The system will now exit...");
			return null;
		}
	
		return new Random(Long.parseLong(arguments[0]));
	}
}