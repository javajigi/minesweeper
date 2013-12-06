package minesweeper.engine;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import minesweeper.engine.Grid;
import minesweeper.engine.Position;
import minesweeper.engine.Square;

import org.junit.Test;

public class GridTest {
	@Test
	public void openSquare() throws Exception {
		Grid grid = new Grid(3, 3);
		grid.openSquare(new Position(2, 2));
		
		List<Square> expected = new ArrayList<Square>();
		for (int i = 1; i <= grid.sizeOfGrid().countOfSquares(); i++) {
			expected.add(Square.openedSquare());
		}
		assertThat(grid.getSquares(), is(expected));
	}
	
	@Test
	public void putMine() throws Exception {
		Grid grid = new Grid(3, 3);
		grid.putMine(new Position(1, 1));
		Square oneToTwo = grid.findSquare(new Position(1, 2));
		assertThat(oneToTwo.getCountOfNeighborMines(), is(1));
		Square twoToOne = grid.findSquare(new Position(2, 1));
		assertThat(twoToOne.getCountOfNeighborMines(), is(1));
		Square twoToTwo = grid.findSquare(new Position(2, 2));
		assertThat(twoToTwo.getCountOfNeighborMines(), is(1));
	}
}
