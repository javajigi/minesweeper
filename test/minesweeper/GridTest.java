package minesweeper;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class GridTest {
	static final Grid TWO_BY_THREE = new Grid(Position.create(2, 3));
	static final Grid THREE_BY_THREE = new Grid(Position.create(3, 3));
	
	@Test
	public void openSquare() throws Exception {
		Grid grid = THREE_BY_THREE;
		grid.openSquare(Position.create(2, 2));
		
		List<Square> expected = new ArrayList<Square>();
		for (int i = 0; i < grid.sizeOfGrid().getSizeOfGrid(); i++) {
			expected.add(Square.openedSquare());
		}
		
		assertThat(grid.getSquares(), is(expected));
	}
}
