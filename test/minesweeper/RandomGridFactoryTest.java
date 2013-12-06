package minesweeper;

import org.junit.Test;

public class RandomGridFactoryTest {

	@Test
	public void create() {
		GridFactory gridFactory = new RandomGridFactory();

		GridSize gridSize = new GridSize(5, 5);
		int countOfMine = 5;
		Grid grid = gridFactory.create(gridSize, countOfMine);
		System.out.println(new ConsoleView().render(grid));
	}

}
