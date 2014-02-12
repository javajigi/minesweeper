package minesweeper;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ListGridManagerTest {
	final static String LIST = "list"; 
	
	GridManager grid;
	GridManager grid3by3;
	GridManager grid5by5;

	@Before
	public void setUp() {
		grid = new GridManager(2, 2, LIST);
		grid3by3 = new GridManager(3,3, LIST);
		grid5by5 = new GridManager(5,5, LIST);
	}

	@Test
	public void initGrid() {
		assertEquals(2, grid.getRow());
		assertEquals(2, grid.getCol());
		
		grid = new GridManager(2, 3, LIST);
		assertEquals(2, grid.getRow());
		assertEquals(3, grid.getCol());
	}

	@Test
	public void oneByOnePrint() throws Exception {
		grid = new GridManager(1, 1, LIST);
		assertEquals("C\n", grid.printConsole());
		grid.setFlag(0, 0);
		assertEquals("F\n", grid.printConsole());
	}
	
	@Test
	public void twoByTwoPrint() throws Exception {
		grid = new GridManager(2, 2, LIST);
		assertEquals("CC\nCC\n", grid.printConsole());
		
		grid.setFlag(0, 0);
		assertEquals("FC\nCC\n", grid.printConsole());
		
		grid.openSquare(0, 1);
		assertEquals("00\n00\n", grid.printConsole());
		
		grid.putMine(1, 1);
		assertEquals("11\n1M\n", grid.printConsole());
	}
	
	@Test
	public void numberOfMine() throws Exception {
		grid = new GridManager(2, 2, LIST);
		grid.putMine(0, 0);
		
		grid.openSquare(1, 1);
		grid.openSquare(0, 1);
		grid.openSquare(1, 0);
		assertEquals("C1\n11\n", grid.printConsole());
	}
	
	@Test
	public void noMineWin() throws Exception {
		assertFalse(grid.isGameOver());
		grid.openSquare(0, 0);
		grid.openSquare(0, 1);
		grid.openSquare(1, 0);
		grid.openSquare(1, 1);
		assertTrue(grid.isGameOver());
	}

	@Test
	public void openNoMineSquare() throws Exception {
		assertEquals(0, grid.getNumberOfMine());
		grid.putMine(0, 0);
		grid.openSquare(1, 1);
		assertEquals(1, grid.getSquare(1,1).getNumOfNearMines());
		grid.putMine(1, 0);
		assertEquals(2, grid.getSquare(1,1).getNumOfNearMines());
		grid.putMine(0, 1);
		assertEquals(3, grid.getSquare(1,1).getNumOfNearMines());
		grid.putMine(1, 1);
	}
	
	@Test
	public void isFlag() throws Exception {
		assertFalse(grid.isFlag(0, 0));
		grid.setFlag(0, 0);
		assertTrue(grid.isFlag(0, 0));
	}
	
	@Test
	public void gameOver()  {
		grid.putMine(0, 0);
		try {
			grid.openSquare(0, 0);
		} catch (GameoverException e) {
			grid.openAll();
			assertEquals("M1\n11\n", grid.printConsole());
		}
	}
	
	@Test
	public void grid3by3() throws Exception {
		grid3by3.openSquare(1, 1);
		
		assertEquals(0, grid3by3.getSquare(1,1).getNumOfNearMines());
		grid3by3.putMine(0, 0);
		grid3by3.putMine(0, 1);
		grid3by3.putMine(0, 2);
		grid3by3.putMine(1, 0);
		assertEquals(4, grid3by3.getSquare(1,1).getNumOfNearMines());
		grid3by3.putMine(1, 2);
		grid3by3.putMine(2, 0);
		grid3by3.putMine(2, 1);
		grid3by3.putMine(2, 2);
		assertEquals(8, grid3by3.getSquare(1,1).getNumOfNearMines());
	}
	
	@Test
	public void openSquareWhenNearMineZero() throws Exception {
		grid3by3.openSquare(1, 1);
		assertEquals("000\n000\n000\n", grid3by3.printConsole());
		
		grid3by3 = new GridManager(3, 3, LIST);
		grid3by3.putMine(0, 0);
		grid3by3.openSquare(1, 1);
		assertEquals("CCC\nC1C\nCCC\n", grid3by3.printConsole());
		grid3by3.openSquare(2, 2);
		assertEquals("C10\n110\n000\n", grid3by3.printConsole());
		
		grid5by5.putMine(1, 1);
		grid5by5.openSquare(4, 4);
		assertEquals("CC100\nCC100\n11100\n00000\n00000\n", grid5by5.printConsole());
	}
	
	
}
