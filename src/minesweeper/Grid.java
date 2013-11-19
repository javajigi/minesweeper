package minesweeper;

public class Grid {

	private int numberOfMine = 0;

	private Square grid[][];

	public Grid(int row, int col) {
		grid = new Square[row][col];

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				grid[i][j] = new Square();
			}
		}
	}

	public int getRow() {
		return grid.length;
	}

	public int getCol() {
		return grid[0].length;
	}

	public int getNumberOfMine() {
		return numberOfMine;
	}

	public boolean isGameOver() {
		if (numberOfMine == getRow() * getCol()) {
			return true;
		}

		if (isAllOpen()) {
			return true;
		}
		return false;
	}

	private boolean isAllOpen() {
		for (int i = 0; i < getRow(); i++) {
			for (int j = 0; j < getCol(); j++) {
				if (!grid[i][j].isOpen()) {
					return false;
				}
			}
		}
		return true;
	}

	public void putMine(int row, int col) {
		if (!grid[row][col].hasMine()) {
			grid[row][col].setMine();
			++numberOfMine;
		}
	}

	public int openSquare(int i, int j) {
		if (!isValidPosition(i, j)) {
			return 0;
		}

		Square square = grid[i][j];
		square.setOpen();
		if (square.isNoNeighborMine()) {
			openSquare(i + 1, j);
			openSquare(i, j + 1);
		}

		if (square.hasMine()) {
			return 0;
		}
		return numberOfMine;
	}

	private boolean isValidPosition(int i, int j) {
		return (i > -1 && i < getRow()) && (j > -1 && j < getCol());
	}

	public Square getSquare(int row, int col) {
		return grid[row][col];
	}

	public boolean isFlag(int i, int j) {
		return grid[i][j].isFlag();
	}

	public void setFlag(int i, int j) {
		grid[i][j].setFlag();
	}

	public boolean isLose() {
		for (int i = 0; i < getRow(); i++) {
			for (int j = 0; j < getCol(); j++) {
				if (grid[i][j].isLose()) {
					return true;
				}
			}
		}
		return false;
	}

	public String generate() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < getRow(); i++) {
			for (int j = 0; j < getCol(); j++) {
				sb.append(grid[i][j].status());
			}
			sb.append("\n");
		}
		return sb.toString();
	}
}
