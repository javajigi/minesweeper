package minesweeper.engine;


public class MockGridFactory implements GridFactory {
	public Grid create(GridSize gridSize, int countOfMine) {
		Grid grid = new Grid(gridSize);
		grid.putMine(new Position(1, 1));
		grid.putMine(new Position(1, 2));
		return grid;
	}
}
