package minesweeper.engine;

import javax.inject.Inject;


public class MockGridFactory implements GridFactory {
	private NeighborSquareFinder neighborSquareFinder;

	@Inject
	public MockGridFactory(NeighborSquareFinder neighborSquareFinder) {
		this.neighborSquareFinder = neighborSquareFinder;
	}
	
	public Grid create(GridSize gridSize, int countOfMine) {
		Grid grid = new Grid(neighborSquareFinder, gridSize);
		grid.putMine(new Position(1, 1));
		grid.putMine(new Position(1, 2));
		return grid;
	}
}
