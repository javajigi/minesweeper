package minesweeper.view;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import javax.inject.Inject;

import minesweeper.engine.Grid;
import minesweeper.engine.GridFactory;
import minesweeper.engine.GridSize;
import minesweeper.engine.Position;
import minesweeper.service.MineSweeper;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import support.GuiceJUnitRunner;
import support.GuiceJUnitRunner.GuiceModules;
import configure.MineSweeperTestModule;
import configure.ViewModule;

@RunWith(GuiceJUnitRunner.class)
@GuiceModules({ ViewModule.class, MineSweeperTestModule.class })
public class MineSweeperAcceptanceTest {
	@Inject
	private View view;
	
	@Inject
	private GridFactory gridFactory;

	private MineSweeper mineSweeper;
	
	@Before
	public void setup() {
		mineSweeper = new MineSweeper(gridFactory);
		final GridSize gridSize = new GridSize(3, 3);
		final int countOfMine = 2;
		mineSweeper.start(gridSize, countOfMine);
	}
	
	@Test
	public void Grid_최초_생성() {
		assertThat(renderView(mineSweeper.getGrid()), is("CCC\nCCC\nCCC\n"));
	}
	
	private String renderView(Grid grid) {
		return view.render(grid);
	}
	
	@Test
	public void 지뢰찾기_게임() throws Exception {
		mineSweeper.openSquare(new Position(3, 3));
		String actual = renderView(mineSweeper.getGrid());
		assertThat(actual, is("CCC\n221\n000\n"));
	}
}
