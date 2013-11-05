package minesweeper;

public class Map {

	private int row;
	private int col;
	
	

	public Map(int row, int col) {
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
		
		return 1;
	}

	public boolean isWin() {
		
		return true;
	}

}
