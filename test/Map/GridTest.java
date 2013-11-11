package Map;

import static org.junit.Assert.*;
import org.junit.Test;

public class GridTest {
	
	Grid oneByOne;
	Grid oneByOne2;
	Grid twoByTwo;
	
	
	@Test
	public void oneByOneInit(){
		oneByOne = new Grid(1, 1, 0); //No mine
		assertTrue(oneByOne.checkInit(1,1));
	}
	
	@Test
	public void oneByOneFlag(){
		oneByOne = new Grid(1, 1, 0); //No mine
		assertFalse(oneByOne.isFlag(0, 0));
		oneByOne.setFlag(0, 0);
		assertTrue(oneByOne.isFlag(0, 0));
	}
	
	@Test
	public void checkGameOver(){
		oneByOne = new Grid(1, 1, 0);
		
		assertFalse(oneByOne.isGameOver()); //빈공간 존재 
		oneByOne.openSquare(0, 0); //좌표입력 
		assertTrue(oneByOne.isGameOver());
		
		oneByOne2 = new Grid(1, 1, 1);
		assertFalse(oneByOne2.isGameOver());
	}
	
	@Test
	public void twoByTwo(){
		twoByTwo = new Grid(2, 2, 0);
		assertTrue(twoByTwo.checkInit(2, 2));
		twoByTwo.printGrid();
	}
	
	@Test
	public void loseTest(){
		twoByTwo = new Grid(2, 2, 1);
		twoByTwo.setMine(0, 0);
		twoByTwo.openSquare(0, 0);
	}
	
	
	
	
}
