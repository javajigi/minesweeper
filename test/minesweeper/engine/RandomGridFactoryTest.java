package minesweeper.engine;

import javax.inject.Inject;

import minesweeper.engine.Grid;
import minesweeper.engine.GridFactory;
import minesweeper.engine.GridSize;
import minesweeper.engine.RandomGridFactory;
import minesweeper.engine.View;

import org.junit.Test;
import org.junit.runner.RunWith;

import configure.ViewModule;
import support.GuiceJUnitRunner;
import support.GuiceJUnitRunner.GuiceModules;

@RunWith(GuiceJUnitRunner.class)
@GuiceModules({ ViewModule.class })
public class RandomGridFactoryTest {
	@Inject
	private View view;

	@Test
	public void create() {
		GridFactory gridFactory = new RandomGridFactory();

		GridSize gridSize = new GridSize(5, 5);
		int countOfMine = 5;
		Grid grid = gridFactory.create(gridSize, countOfMine);
		System.out.println(view.render(grid));
	}

}
