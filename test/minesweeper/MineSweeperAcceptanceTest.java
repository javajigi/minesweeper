package minesweeper;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import support.GuiceJUnitRunner;
import support.GuiceJUnitRunner.GuiceModules;
import support.ViewModule;

@RunWith(GuiceJUnitRunner.class)
@GuiceModules({ ViewModule.class })
public class MineSweeperAcceptanceTest {
	@Inject
	private View view;
	
	@Test
	public void 지뢰찾기_게임() throws Exception {
		final int expectedCountOfMine = 2;
		final GridSize expectedGridSize = new GridSize(3, 3);
		GridFactory gridFactory = createGridFactory(expectedGridSize, expectedCountOfMine);
		MineSweeper mineSweeper = new MineSweeper(gridFactory, view);
		mineSweeper.start(expectedGridSize, expectedCountOfMine);
		mineSweeper.openSquare(new Position(3, 3));
		String actual = mineSweeper.render();
		assertThat(actual, is("CCC\n221\n000\n"));
	}

	private GridFactory createGridFactory(final GridSize expectedGridSize, final int expectedCountOfMine) {
		return new GridFactory() {
			@Override
			public Grid create(GridSize gridSize, int countOfMine) {
				assertThat(gridSize, is(expectedGridSize));
				assertThat(countOfMine, is(expectedCountOfMine));
				Grid grid = new Grid(gridSize);
				grid.putMine(new Position(1, 1));
				grid.putMine(new Position(1, 2));
				return grid;
			}
		};
	}
}
