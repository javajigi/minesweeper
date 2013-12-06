package minesweeper;

import java.util.ArrayList;
import java.util.List;

public class Grid {
	private List<Square> squares;
	private GridSize sizeOfGrid;
	
	public Grid(int sizeOfRow, int sizeOfColumn) {
		this(new GridSize(sizeOfRow, sizeOfColumn));
	}

	public Grid(GridSize sizeOfGrid) {
		this.sizeOfGrid = sizeOfGrid;
		
		squares = new ArrayList<Square>(sizeOfGrid.countOfSquares());
		for (int i = 0; i < sizeOfGrid.countOfSquares(); i++) {
			squares.add(Square.closedSquare());
		}
	}
	
	Square findSquare(Position position) {
		return squares.get(sizeOfGrid.indexOfSquare(position));
	}

	public void openSquare(Position position) {
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
		List<Position> positions = sizeOfGrid.findNeighborPositions(position);
		for (Position each : positions) {
			openSquare(each);
		}
	}

	public List<Square> getSquares() {
		return squares;
	}
	
	public GridSize sizeOfGrid() {
		return sizeOfGrid;
	}

	void putMine(Position position) {
		Square currentSquare = findSquare(position);
		if (currentSquare.isMine()) {
			return;
		}
		currentSquare.mined();
		
		List<Position> positions = sizeOfGrid.findNeighborPositions(position);
		for (Position each : positions) {
			findSquare(each).increaseCountOfNeighborMines();
		}
	}
}
