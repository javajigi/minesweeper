package minesweeper;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import support.GuiceJUnitRunner;
import support.GuiceJUnitRunner.GuiceModules;
import support.ViewModule;

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
