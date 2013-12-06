package minesweeper.engine;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;

import support.GuiceJUnitRunner;
import support.GuiceJUnitRunner.GuiceModules;
import configure.MineSweeperTestModule;

@RunWith(GuiceJUnitRunner.class)
@GuiceModules({ MineSweeperTestModule.class })
public class GridTest {
	public static Grid createBy(GridSize gridSize) {
		return new Grid(new DefaultNeighborSquareFinder(), gridSize);
	}
	
	@Test
	public void openSquare() throws Exception {
		Grid grid = createBy(new GridSize(3, 3));
		grid.openSquare(new Position(2, 2));
		
		List<Square> expected = new ArrayList<Square>();
		for (int i = 1; i <= grid.sizeOfGrid().countOfSquares(); i++) {
			expected.add(Square.openedSquare());
		}
		assertThat(grid.getSquares(), is(expected));
	}
	
	@Test
	public void putMine() throws Exception {
		Grid grid = createBy(new GridSize(3, 3));
		grid.putMine(new Position(1, 1));
		Square oneToTwo = grid.findSquare(new Position(1, 2));
		assertThat(oneToTwo.getCountOfNeighborMines(), is(1));
		Square twoToOne = grid.findSquare(new Position(2, 1));
		assertThat(twoToOne.getCountOfNeighborMines(), is(1));
		Square twoToTwo = grid.findSquare(new Position(2, 2));
		assertThat(twoToTwo.getCountOfNeighborMines(), is(1));
	}
}
