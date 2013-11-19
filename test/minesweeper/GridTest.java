package minesweeper;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GridTest {
	Grid grid;

	@Before
	public void setUp() {
		grid = new Grid(2, 2);
	}

	@Test
	public void initGrid() {
		assertEquals(2, grid.getRow());
		assertEquals(2, grid.getCol());
		
		grid = new Grid(2, 3);
		assertEquals(2, grid.getRow());
		assertEquals(3, grid.getCol());
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
		assertEquals(1, grid.openSquare(1, 1));
		assertEquals(0, grid.openSquare(0, 0));
		grid.putMine(1, 0);
		assertEquals(2, grid.openSquare(1, 1));
		grid.putMine(0, 1);
		assertEquals(3, grid.openSquare(1, 1));
		grid.putMine(0, 1);
		assertEquals(3, grid.openSquare(1, 1));
		grid.putMine(1, 1);
		assertTrue(grid.isGameOver());
	}
	
	@Test
	public void isFlag() throws Exception {
		assertFalse(grid.isFlag(0, 0));
		grid.setFlag(0, 0);
		assertTrue(grid.isFlag(0, 0));
	}
	
	@Test
	public void isLose() throws Exception {
		grid.putMine(0, 0);
		grid.openSquare(0, 0);
		assertTrue(grid.isLose());
	}
	
	@Test
	public void oneByOneWhenNoMine() throws Exception {
		grid = new Grid(1, 1);
		assertEquals(".\n", grid.generate());
		grid.setFlag(0, 0);
		assertEquals("X\n", grid.generate());
		grid.openSquare(0, 0);
		assertEquals("0\n", grid.generate());
		assertTrue(grid.isGameOver());
	}
	
	@Test
	public void oneByOneWhenMine() throws Exception {
		grid = new Grid(1, 1);
		grid.putMine(0, 0);
		assertEquals(".\n", grid.generate());
		grid.setFlag(0, 0);
		assertEquals("X\n", grid.generate());
		grid.openSquare(0, 0);
		assertEquals("*\n", grid.generate());
		assertTrue(grid.isGameOver());
	}
	
	@Test
	public void twoByTwoWhenNoMine() throws Exception {
		grid = new Grid(2, 2);
		assertEquals("..\n..\n", grid.generate());
		grid.openSquare(0, 0);
		assertEquals("00\n00\n", grid.generate());
	}
}
