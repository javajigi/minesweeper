package minesweeper.engine;

public interface GridFactory {
	Grid create(GridSize gridSize, int countOfMine);
}