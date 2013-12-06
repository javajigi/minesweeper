package minesweeper.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import javax.inject.Inject;

import minesweeper.engine.GridFactory;
import minesweeper.engine.GridSize;
import minesweeper.engine.Position;
import minesweeper.engine.View;

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
	
	@Test
	public void 지뢰찾기_게임() throws Exception {
		final int expectedCountOfMine = 2;
		final GridSize expectedGridSize = new GridSize(3, 3);
		MineSweeper mineSweeper = new MineSweeper(gridFactory, view);
		mineSweeper.start(expectedGridSize, expectedCountOfMine);
		mineSweeper.openSquare(new Position(3, 3));
		String actual = mineSweeper.render();
		assertThat(actual, is("CCC\n221\n000\n"));
	}
}
