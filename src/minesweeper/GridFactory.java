package minesweeper;

interface GridFactory {
	Grid create(GridSize gridSize, int countOfMine);
}