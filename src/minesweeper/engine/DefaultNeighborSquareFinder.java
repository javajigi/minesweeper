package minesweeper.engine;

import java.util.ArrayList;
import java.util.List;

import minesweeper.engine.Position.Direction;

public class DefaultNeighborSquareFinder implements NeighborSquareFinder {

	@Override
	public List<Position> findNeighborPositions(GridSize gridSize, Position position) {
		List<Position> neighborPositions = new ArrayList<Position>();
		Direction[] directions = Direction.values();
		for (Direction direction : directions) {
			try {
				Position movedPosition = position.move(direction);
				if (gridSize.isValid(movedPosition)) {
					neighborPositions.add(movedPosition);
				}
			} catch (IndexOutOfBoundsException e) {
				continue;
			}
		}
		return neighborPositions;
	}

}
