package minesweeper.engine;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class RandomGridFactory implements GridFactory {
	private NeighborSquareFinder neighborSquareFinder;

	@Inject
	public RandomGridFactory(NeighborSquareFinder neighborSquareFinder) {
		this.neighborSquareFinder = neighborSquareFinder;
	}
	
	@Override
	public Grid create(GridSize gridSize, int countOfMine) {
		Grid grid = new Grid(neighborSquareFinder, gridSize);
		RandomPositionGenerator generator = new RandomPositionGenerator(gridSize, countOfMine);
		List<Position> randomPositions = generator.generate();
		for (Position position : randomPositions) {
			grid.putMine(position);
		}
		return grid;
	}

}
