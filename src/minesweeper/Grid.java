package minesweeper;

import java.util.ArrayList;
import java.util.List;

class Grid {
	private List<Square> squares;
	private Position sizeOfGrid;

	Grid(Position sizeOfGrid) {
		this.sizeOfGrid = sizeOfGrid;
		
		squares = new ArrayList<Square>(sizeOfGrid.getSizeOfGrid());
		for (int i = 0; i < sizeOfGrid.getSizeOfGrid(); i++) {
			squares.add(Square.closedSquare());
		}
	}

	void openSquare(Position position) {
		for (Square square : squares) {
			square.opened();
		}
	}

	List<Square> getSquares() {
		return squares;
	}
	
	Position sizeOfGrid() {
		return sizeOfGrid;
	}
}
