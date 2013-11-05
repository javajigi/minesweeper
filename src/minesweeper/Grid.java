package minesweeper;

public class Grid {

	private int row;
	private int col;
	private int numberOfMine = 0;
	
	private boolean isWin = false;
	private boolean flag = false;

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

	public void openSquare() {
		isWin = true;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag() {
		this.flag = true;
	}

}
