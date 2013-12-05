package minesweeper;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class GridTest {
	@Test
	public void openSquare() throws Exception {
		int sizeOfRow = 3;
		int sizeOfColumn = 3;
		Grid grid = new Grid(sizeOfRow, sizeOfColumn);
		grid.openSquare(2, 2);
		
		List<Square> expected = new ArrayList<Square>();
		for (int i = 0; i < sizeOfRow * sizeOfColumn; i++) {
			expected.add(Square.openedSquare());
		}
		
		assertThat(grid.getSquares(), is(expected));
	}
}
