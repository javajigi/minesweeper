package minesweeper;

public class Row {
	private Square[] squares;

	public Row(int column) {
		squares = new Square[column];
		for (int i = 0; i < column; i++) {
			squares[i] = new Square();
		}
	}

	public int sizeOfColumn() {
		return squares.length;
	}

	public Square findSquare(int column) {
		return squares[column];
	}

	public boolean isLose() {
		for (int j = 0; j < sizeOfColumn(); j++) {
			if (findSquare(j).isLose()) {
				return true;
			}
		}
		return false;
	}

	public void increaseMineCount(int col) {
		int startCol = (col - 1 < 0) ? col : col - 1;
		int endCol = (col + 1 < sizeOfColumn()) ? col + 1 : col;

		for (int j = startCol; j <= endCol; j++) {
			squares[j].increaseMineCount();
		}
	}

	public void putMine(int col) {
		squares[col].setMine();
	}
}
