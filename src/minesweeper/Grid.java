package minesweeper;

public class Grid {

	private int row;
	private int col;
	private int numberOfMine = 0;
	
	private boolean isWin = false;

	public Grid(int row, int col) {
		this.row = row;
		this.col = col;
	}

	public int getRow() {
		return row;
	}

	public int getCol() {
		return col;
	}

	public int getNumberOfMine() {
		
		return numberOfMine;
	}

	public boolean isGameOver() {
		if (numberOfMine == 1) {
			isWin = true;
		}
		return isWin;
	}

	public void putMine() {
		numberOfMine = 1;
	}

	public void openSquare(int i, int j) {
		isWin = true;
	}

}
