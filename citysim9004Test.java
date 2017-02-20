import org.junit.Test;
import org.Mockito.Mockito.*;
import static org.junit.Assert.*;


public class citysim9004Test
{

	// Test that seedRandom method returns null on incorrect args entry (thereby flipping the if clause below it and 
	//	causing the system to exit.)
	@Test
	public void testArgsLength() 
	{
		
		String[] testArgs = {};
		Random r = citysim9004.seedRandom(testArgs);
		assertNull(r);
		
		String[] testArgs = new String[2];
		Random r = citysim9004.seedRandom(testArgs);
		assertNull(r);
	}
	
	// Test that seedRandom properly seeds the random number generator according to the user's input.
	// Create and seed a random generator with the same see as is passed to the method, and ensure they return the same numbers.
	@Test 
	public void testRandomSeed()
	{
		Random rand = new Random(1);
		String[] testArgs = {"1"};
		Random r = seedRandom(testArgs);
		
		for (int i = 0; i < 10; i ++)
			assertEquals(rand.nextInt(), r.nextInt());
	}
	
	// Test that getRoadLastTravelled returns the proper previous road by examining current/previous nodes.
	@Test
	public void testGetLastRoad()
	{
		Location mockLoc = Mockito.mock(Location.class);
		Location mockLoc2 = Mockito.mock(Location.class);
		Mockito.when(mockLoc.getName()).thenReturn("Presby");
		Mockito.when(mockLoc2.getName()).thenReturn("OutsideCity");
		assertEquals(Driver.getRoadLastTravelled(mockLoc, mockLoc2), "Fourth Ave.");
		
		mockLoc = Mockito.mock(Location.class);
		mockLoc2 = Mockito.mock(Location.class);
		Mockito.when(mockLoc.getName()).thenReturn("Presby");
		Mockito.when(mockLoc2.getName()).thenReturn("Sennott");
		assertEquals(Driver.getRoadLastTravelled(mockLoc, mockLoc2), "Bill St.");
		
		mockLoc = Mockito.mock(Location.class);
		mockLoc2 = Mockito.mock(Location.class);
		Mockito.when(mockLoc.getName()).thenReturn("Union");
		Mockito.when(mockLoc2.getName()).thenReturn("Presby");
		assertEquals(Driver.getRoadLastTravelled(mockLoc, mockLoc2), "Fourth Ave.");
		
		mockLoc = Mockito.mock(Location.class);
		mockLoc2 = Mockito.mock(Location.class);
		Mockito.when(mockLoc.getName()).thenReturn("Union");
		Mockito.when(mockLoc2.getName()).thenReturn("Hillman");
		assertEquals(Driver.getRoadLastTravelled(mockLoc, mockLoc2), "Phil St.");
		
		mockLoc = Mockito.mock(Location.class);
		mockLoc2 = Mockito.mock(Location.class);
		Mockito.when(mockLoc.getName()).thenReturn("OutsideCity");
		Mockito.when(mockLoc2.getName()).thenReturn("Union");
		assertEquals(Driver.getRoadLastTravelled(mockLoc, mockLoc2), "Fourth Ave.");
		
		mockLoc = Mockito.mock(Location.class);
		mockLoc2 = Mockito.mock(Location.class);
		Mockito.when(mockLoc.getName()).thenReturn("Hillman");
		Mockito.when(mockLoc2.getName()).thenReturn("Union");
		assertEquals(Driver.getRoadLastTravelled(mockLoc, mockLoc2), "Phil St.");
		
		mockLoc = Mockito.mock(Location.class);
		mockLoc2 = Mockito.mock(Location.class);
		Mockito.when(mockLoc.getName()).thenReturn("Hillman");
		Mockito.when(mockLoc2.getName()).thenReturn("OutsideCity");
		assertEquals(Driver.getRoadLastTravelled(mockLoc, mockLoc2), "Fifth Ave.");
		
		mockLoc = Mockito.mock(Location.class);
		mockLoc2 = Mockito.mock(Location.class);
		Mockito.when(mockLoc.getName()).thenReturn("Sennott");
		Mockito.when(mockLoc2.getName()).thenReturn("Hillman");
		assertEquals(Driver.getRoadLastTravelled(mockLoc, mockLoc2), "Fifth Ave.");
		
		mockLoc = Mockito.mock(Location.class);
		mockLoc2 = Mockito.mock(Location.class);
		Mockito.when(mockLoc.getName()).thenReturn("Sennott");
		Mockito.when(mockLoc2.getName()).thenReturn("Presby");
		assertEquals(Driver.getRoadLastTravelled(mockLoc, mockLoc2), "Bill St.");
		
		mockLoc = Mockito.mock(Location.class);
		mockLoc2 = Mockito.mock(Location.class);
		Mockito.when(mockLoc.getName()).thenReturn("OutsideCity");
		Mockito.when(mockLoc2.getName()).thenReturn("Sennott");
		assertEquals(Driver.getRoadLastTravelled(mockLoc, mockLoc2), "Fifth Ave.");
		
	}
}