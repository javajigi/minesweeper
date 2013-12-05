package minesweeper;

import java.util.ArrayList;
import java.util.List;

class Grid {
	private List<Square> squares;
	private int sizeOfRow;
	private int sizeOfColumn;

	Grid(int sizeOfRow, int sizeOfColumn) {
		this.sizeOfRow = sizeOfRow;
		this.sizeOfColumn = sizeOfColumn;
		
		squares = new ArrayList<Square>(sizeOfRow * sizeOfColumn);
		for (int i = 0; i < sizeOfRow * sizeOfColumn; i++) {
			squares.add(Square.closedSquare());
		}
	}

	void openSquare(int x, int y) {
		for (Square square : squares) {
			square.opened();
		}
	}

	List<Square> getSquares() {
		return squares;
	}

	int sizeOfRow() {
		return this.sizeOfRow;
	}

	public int sizeOfColumn() {
		return this.sizeOfColumn;
	}

}
