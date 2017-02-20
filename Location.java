import java.util.*;
import java.io.*;
import java.lang.*;

public class Location
{
	public String name;
	public Location[] connections;

	public Location(String input)
	{
		this.name = input;
	}
	
	public Location[] getConnections()
	{	
		return connections;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setConnections(Location[] edges)
	{
		connections = edges;
	}
}