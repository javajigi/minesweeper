package board;

import java.util.Random;

public class Grid {
	private int rowSize;
	private int colSize;
	private int numberOfMine;

	public boolean[][] board;

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
		board = new boolean[rowSize][colSize];
	}

	public boolean getState(int i, int j) {
		if (board[i][j] == true)
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
			} while (board[randX][randY] == true);

			board[randX][randY] = true;
		}
	}
}
