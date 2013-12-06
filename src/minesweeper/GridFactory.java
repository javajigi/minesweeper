package minesweeper;

public interface GridFactory {
	Grid create(GridSize gridSize, int countOfMine);
}