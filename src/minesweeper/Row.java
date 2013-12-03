package minesweeper;

public class Row {
	private Square[] squares;

	public Row(int column) {
		squares = new Square[column];
		for (int i = 0; i < column; i++) {
			squares[i] = new Square();
		}
	}

	public int getCol() {
		return squares.length;
	}

	public void increaseNearNumberOfMine(int col) {
		int startCol = (col-1 < 0)? col : col-1;
		int endCol = (col+1 < getCol())? col+1 : col;
		
		for (int j = startCol; j <= endCol; j++) {
			squares[j].setNumOfNearMines();
		}		
	}

	public void setMine(int col) {
		squares[col].setMine();
	}
	
	public Square getSquare(int col) {
		return squares[col];
	}

	public boolean isLose() {
		for (int j = 0; j < getCol(); j++) {
			if (getSquare(j).isLose()) {
				return true;
			}
		}
		return false;
	}

	public boolean isAllOpen() {
		for (int j = 0; j < getCol(); j++) {
			if (!getSquare(j).isOpen()) {
				return false;
			}
		}
		
		return true;
	}

	public void openAll() {
		for (int j = 0; j < getCol(); j++) {
			squares[j].setOpen();
		}
		
	}

	public void openSquare(int row, int col, Grid grid) throws GameoverException {
		int startCol = (col-1 < 0)? col : col-1;
		int endCol = (col+1 < getCol())? col+1 : col;
		
		for (int j = startCol; j <= endCol; j++) {
			if (squares[j].isOpen()) continue;

			squares[j].setOpen();
			if (squares[j].getNumOfNearMines() == 0)
				grid.openSquare(row, j);
		}	
		
	}

}
