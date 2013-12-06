package minesweeper;

import java.util.List;

public class RandomGridFactory implements GridFactory {
	@Override
	public Grid create(GridSize gridSize, int countOfMine) {
		Grid grid = new Grid(gridSize);
		RandomPositionGenerator generator = new RandomPositionGenerator(gridSize, countOfMine);
		List<Position> randomPositions = generator.generate();
		for (Position position : randomPositions) {
			grid.putMine(position);
		}
		return grid;
	}

}
