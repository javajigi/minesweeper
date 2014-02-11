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

	public void setAllDummy() {
		for ( int i = 0 ; i < getCol() ; i++){
			squares[i].setDummy();
		}
	}

	public void setDummy() {
		squares[0].setDummy();
		squares[getCol()].setDummy();
	}
}
