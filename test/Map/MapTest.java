package Map;

import static org.junit.Assert.*;
import org.junit.Test;

public class MapTest {
	
	Map oneByOne;
	Map oneByOne2;
	
	
	@Test
	public void oneByOneInit(){
		oneByOne = new Map(1, 1, 0); //No mine
		assertTrue(oneByOne.checkInit(1,1));
	}
	
	@Test
	public void oneByOneFlag(){
		oneByOne = new Map(1, 1, 0); //No mine
		assertFalse(oneByOne.isFlag(0, 0));
		oneByOne.setFlag(0, 0);
		assertTrue(oneByOne.isFlag(0, 0));
	}
	
	@Test
	public void checkGameOver(){
		oneByOne = new Map(1, 1, 0);
		
		assertFalse(oneByOne.isGameOver()); //빈공간 존재 
		oneByOne.clickSpace(0, 0); //좌표입력 
		assertTrue(oneByOne.isGameOver());
		
		oneByOne2 = new Map(1, 1, 1);
		assertFalse(oneByOne2.isGameOver());
	}
	
	
	
	
}
