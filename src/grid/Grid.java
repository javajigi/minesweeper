package grid;

import java.util.Random;

public class Grid {
	private int rowSize;
	private int colSize;
	private int numberOfMine;

	public enum square {
		MINE, NONE, COVERED, OPENED, FLAG
	}
	
	public square[][][] grid;

	// public boolean[][] grid;

	public Grid() {
	}

	public int getRowSize() {
		return rowSize;
	}

	public int getColSize() {
		return colSize;
	}

	public void init(int x, int y) {
		rowSize = x;
		colSize = y;
		grid = new square[rowSize][colSize][2];
		for (int i = 0; i < rowSize; i++) {
			for (int j = 0; j < colSize; j++) {
				grid[i][j][0] = square.COVERED;
				grid[i][j][1] = square.NONE;
			}
		}
	}

	public boolean isMine(int i, int j) {
		if (grid[i][j][1] == square.MINE)
			return true;
		return false;
	}

	public void setMine(int x) {

		numberOfMine = x;
		int randX;
		int randY;

		if (numberOfMine > rowSize * colSize) {
			return; // 예외처리를 해야 하는데 생각이 안 난다
		}
		for (int i = 0; i < numberOfMine; i++) {
			do {
				randX = new Random().nextInt(rowSize);
				randY = new Random().nextInt(colSize);
				grid[randX][randY][1] = square.MINE;
			} while (grid[randX][randY][1] == square.MINE);

		}
	}
}
