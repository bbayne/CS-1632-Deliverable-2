import java.util.*;
import java.io.*;
import java.lang.*;

public class Driver 
{
	private Location currentLoc;
	private Location previousLoc;
	private static int sennCount;
	
	public Driver(int startDex, Location[] potentialPoints)
	{
		currentLoc = potentialPoints[startDex];
		previousLoc = null; 
	}
	
	public Location getCurrentLoc()
	{
		return currentLoc;
	}
	
	public Location getNextLoc(int dex)
	{
		return currentLoc.getConnections()[dex];
	}
	
	public Location getPreviousLoc()
	{
		return previousLoc;
	}
	
	public void setCurrentLoc(Location current)
	{
		previousLoc = currentLoc;
		currentLoc = current;
	}
	
	public String getRoadLastTravelled(Location curr, Location prev)
	{
		if (curr.getName().equals("Presby") && prev.getName().equals("OutsideCity"))
			return "Fourth Ave.";
		else if (curr.getName().equals("Presby") && prev.getName().equals("Sennott"))
			return "Bill St.";
		else if (curr.getName().equals("Union") && prev.getName().equals("Presby"))
			return "Fourth Ave.";
		else if (curr.getName().equals("Union") && prev.getName().equals("Hillman"))
			return "Phil St.";
		else if (curr.getName().equals("OutsideCity") && prev.getName().equals("Union"))
			return "Fourth Ave.";
		else if (curr.getName().equals("Hillman") && prev.getName().equals("Union"))
			return "Phil St.";
		else if (curr.getName().equals("Hillman") && prev.getName().equals("OutsideCity"))
			return "Fifth Ave.";
		else if (curr.getName().equals("Sennott") && prev.getName().equals("Hillman"))
			return "Fifth Ave.";
		else if (curr.getName().equals("Sennott") && prev.getName().equals("Presby"))
			return "Bill St.";
		else if (curr.getName().equals("OutsideCity") && prev.getName().equals("Sennott"))
			return "Fifth Ave.";
		else 
			return null;
	}
	
	public static int getSennCount()
	{
		return sennCount;
	}
	
	public void incrementSennCount()
	{
		sennCount++;
	}
}