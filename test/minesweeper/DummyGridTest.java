package minesweeper;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class DummyGridTest {
	int row = 2;
	int column = 2;
	private Grid grid;

	@Before
	public void setup() {
		grid = new DummyGrid(row, column);
	}
	
	
	@Test
	public void create() {
		assertEquals(row, grid.getRow());
		assertEquals(column, grid.getCol());
	}
	
	@Test
	public void getSquare() throws Exception {
		Square square = grid.getSquare(0, 0);
		assertEquals(new Square(), square);
	}
}
