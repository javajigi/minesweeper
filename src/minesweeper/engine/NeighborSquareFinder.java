package minesweeper.engine;

import java.util.List;


public interface NeighborSquareFinder {
	List<Position> findNeighborPositions(GridSize gridSize, Position position);
}
