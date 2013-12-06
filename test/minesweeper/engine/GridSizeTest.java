package minesweeper.engine;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import java.util.List;

import minesweeper.engine.GridSize;
import minesweeper.engine.Position;

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
	
	@Test
	public void findNeighborPositions() throws Exception {
		List<Position> neighborPositions = gridSize.findNeighborPositions(new Position(1, 1));
		assertThat(neighborPositions, containsInAnyOrder(new Position(1,  2), new Position(2, 1), new Position(2, 2)));
	}
	
	@Test
	public void isValid() throws Exception {
		assertTrue(gridSize.isValid(new Position(1, 1)));
		assertTrue(gridSize.isValid(new Position(1, 3)));
		assertTrue(gridSize.isValid(new Position(2, 1)));
		assertTrue(gridSize.isValid(new Position(2, 3)));
	}
	
	@Test
	public void isInValid() throws Exception {
		assertFalse(gridSize.isValid(new Position(3, 1)));
		assertFalse(gridSize.isValid(new Position(2, 4)));
	}
	
	@Test
	public void indexToPosition() throws Exception {
		assertThat(gridSize.indexToPosition(0), is(new Position(1, 1)));
		assertThat(gridSize.indexToPosition(2), is(new Position(1, 3)));
		assertThat(gridSize.indexToPosition(3), is(new Position(2, 1)));
		assertThat(gridSize.indexToPosition(5), is(new Position(2, 3)));
	}
}
