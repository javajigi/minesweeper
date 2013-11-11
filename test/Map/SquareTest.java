package Map;

import static org.junit.Assert.*;

import org.junit.Test;

public class SquareTest {
	
	Square square;
	
	
	@Test
	public void getFlag(){
		square = new Square();

		assertFalse(square.isFlag());
		square.setFlag();
		assertTrue(square.isFlag()); 
	}
	
	@Test
	public void clickSpace(){
		square = new Square();
		assertTrue(square.isEmpty());
		square.setFlag();
		assertFalse(square.isEmpty());
		
	}

}
