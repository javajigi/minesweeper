package minesweeper;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GridSizeTest {
	private GridSize gridSize;
	
	@Before
	public void setup() {
		gridSize = new GridSize(2, 3);
	}

	@Test
	public void init() {
		assertThat(gridSize, is(new GridSize(2, 3)));
	}
	
	@Test
	public void countOfSquares() throws Exception {
		assertThat(gridSize.countOfSquares(), is(6));
	}
	
	@Test
	public void indexOfSquare() throws Exception {
		assertThat(gridSize.indexOfSquare(new Position(1, 1)), is(0));
		assertThat(gridSize.indexOfSquare(new Position(1, 2)), is(1));
		assertThat(gridSize.indexOfSquare(new Position(2, 1)), is(3));
		assertThat(gridSize.indexOfSquare(new Position(2, 3)), is(5));
	}
	
	@Test(expected=IndexOutOfBoundsException.class)
	public void indexOfSquareWhenIndexOutOfBoundRow() throws Exception {
		gridSize.indexOfSquare(new Position(3, 2));
	}
	
	@Test(expected=IndexOutOfBoundsException.class)
	public void indexOfSquareWhenIndexOutOfBoundColumn() throws Exception {
		gridSize.indexOfSquare(new Position(1, 4));
	}

}
