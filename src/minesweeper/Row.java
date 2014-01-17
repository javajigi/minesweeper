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

	/////////////////////////////////
	public void setAllColsDummy() {
		int colLength = getCol();
		for (int i = 0; i < colLength ; i++){
			squares[i].setDummy();
		}
		
	}

	public void setDummy() {
		int colLength = getCol();
		squares[0].setDummy();
		squares[colLength].setDummy();
		
	}
	public void putMine2(int col) {
		squares[col].putMine2();
		
	}


	public boolean isMine(int col) {
		return squares[col].isMine();
	}

	public void increaseNearNumber(int col) {
		squares[col].increaseNearNumber();
		squares[col+1].increaseNearNumber();
		squares[col-1].increaseNearNumber();
		
	}
	/////////////////////////////////

	public char openSquare2(int col) {
		return squares[col].openSquare2();
	}

	public char continueOpen(int col) {
		char result = squares[col].continueOpen();
		continueLeftOpen(col-1);
		continueRightOpen(col+1);
		return result;
	}
	
	private void continueLeftOpen(int col) {
		char result = squares[col].continueOpen();
		if (result == 'Y'){
			continueLeftOpen(col-1);
		}
	}
	
	private void continueRightOpen(int col) {
		char result = squares[col].continueOpen();
		if (result == 'Y'){
			continueLeftOpen(col+1);
		}
	}

}
