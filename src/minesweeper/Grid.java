package minesweeper;

import java.util.ArrayList;
import java.util.List;

class Grid {
	private List<Square> squares;
	private GridSize sizeOfGrid;
	
	Grid(int sizeOfRow, int sizeOfColumn) {
		this(new GridSize(sizeOfRow, sizeOfColumn));
	}

	Grid(GridSize sizeOfGrid) {
		this.sizeOfGrid = sizeOfGrid;
		
		squares = new ArrayList<Square>(sizeOfGrid.countOfSquares());
		for (int i = 0; i < sizeOfGrid.countOfSquares(); i++) {
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
	
	GridSize sizeOfGrid() {
		return sizeOfGrid;
	}
}
