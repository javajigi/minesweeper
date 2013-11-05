package minesweeper;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GridTest {
	Grid grid;
	
	@Before
	public void setUp() {
		grid = new Grid(1, 1);
	}
	
	@Test
	public void initSizeOneByOne() {
		assertEquals(1, grid.getRow());
		assertEquals(1, grid.getCol());
	}
	
	@Test
	public void numberOfMine(){
		assertEquals(0, grid.getNumberOfMine());
		grid.putMine();
		assertEquals(1, grid.getNumberOfMine());
	} 
	
	@Test
	public void oneMineWin() throws Exception {
		grid.putMine();
		assertTrue(grid.isGameOver());
	}
	
	@Test
	public void noMineWin() throws Exception {
		assertFalse(grid.isGameOver());
		grid.openSquare();
		assertTrue(grid.isGameOver());
	}
	
	@Test
	public void isFlag() throws Exception {
		assertFalse(grid.isFlag());
		grid.setFlag();
		assertTrue(grid.isFlag());
	}

}
