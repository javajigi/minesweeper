package Map;

import static org.junit.Assert.*;

import org.junit.Test;

public class SpaceTest {
	
	Space space;
	
	@Test
	public void spaceInit(){
		space = new Space(1);
		assertTrue(space.isGetMine());
	}
	
	@Test
	public void getFlag(){
		space = new Space(1);

		assertFalse(space.isFlag());
		space.setFlag();
		assertTrue(space.isFlag()); 
	}
	
	@Test
	public void clickSpace(){
		space = new Space(0);
		assertTrue(space.isEmpty());
		space.setFlag();
		assertFalse(space.isEmpty());
		
		
	}

}
