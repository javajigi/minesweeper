package minesweeper;

import java.util.ArrayList;
import java.util.List;

import minesweeper.Position.Direction;

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
	
	Square findSquare(Position position) {
		return squares.get(sizeOfGrid.indexOfSquare(position));
	}

	void openSquare(Position position) {
		Square square = findSquare(position);
		if (square.isOpened()) {
			return;
		}
		square.opened();
		if (square.hasNotNeighborMine()) {
			openNeighborSquare(position);
		}
	}

	private void openNeighborSquare(Position position) {
		Direction[] directions = Direction.values();
		for (Direction each : directions) {
			try {
				Position movedPosition = position.move(each);
				openSquare(movedPosition);
			} catch (IndexOutOfBoundsException e) {
				continue;
			}
		}
	}

	List<Square> getSquares() {
		return squares;
	}
	
	GridSize sizeOfGrid() {
		return sizeOfGrid;
	}

	void putMine(Position position) {
		Square currentSquare = findSquare(position);
		if (currentSquare.isMine()) {
			return;
		}
		currentSquare.mined();
		
		Direction[] directions = Direction.values();
		for (Direction each : directions) {
			try {
				Position movedPosition = position.move(each);
				findSquare(movedPosition).increaseCountOfNeighborMines();
			} catch (IndexOutOfBoundsException e) {
				continue;
			}
		}
	}
}
