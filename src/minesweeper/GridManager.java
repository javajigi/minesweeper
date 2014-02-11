package minesweeper;

import normal.NormalGrid;

public class GridManager {

	private int numberOfMine = 0;

	private Grid grid;

	public GridManager(int row, int col) {
		grid = new NormalGrid(row, col);
	}

	public int getRow() {
		return grid.getRow();
	}

	public int getCol() {
		return grid.getCol();
	}

	public int getNumberOfMine() {
		return numberOfMine;
	}

	public boolean isGameOver() {
		if (numberOfMine == getRow() * getCol()) {
			return true;
		}

		if (grid.isAllOpen()) {
			return true;
		}
		return false;
	}

	public void putMine(int row, int col) {
		Position pos = createPosition(row, col);
		
		if(getSquare(pos).isMine()) return;
		getSquare(pos).setMine();
		for (Position eachPos : pos.getNeighbors(getRow(), getCol())) {
			getSquare(eachPos).setNumOfNearMines();
		}
		
	}

	private Position createPosition(int row, int col) {
		return grid.createPosition(row, col);
	}

	public void openSquare(int row, int col) throws GameoverException {
		Position pos = createPosition(row, col);
		Square square = getSquare(pos);
		
		if (square.isMine()) {
			throw new GameoverException();
		}
		
		square.setOpen();
		
		if(square.getNumOfNearMines() != 0) {
			return ;
		}
	
		for (Position eachPos :  pos.getNeighbors(getRow(), getCol())) {
			Square eachSquare = getSquare(eachPos);
			if(!eachSquare.isOpen()) {
				openSquare(eachPos.getX(), eachPos.getY());
			}
		}	
	}

	public Square getSquare(int row, int col) {
		return grid.getSquare(row, col);
	}
	
	public Square getSquare(Position pos) {
		return getSquare(pos.getX(), pos.getY());
	}
	
	public boolean isFlag(int i, int j) {
		Position pos = createPosition(i, j);
		
		return getSquare(pos).isFlag();
	}

	public void setFlag(int i, int j) {
		Position pos = createPosition(i, j);
		getSquare(pos).setFlag();
	}

	public String printConsole() {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < getRow(); i++) {
			for (int j = 0; j < getCol(); j++) {
				result.append(getSquare(i, j).printSymbol());
			}
			result.append("\n");
		}
		System.out.println(result.toString());
		return result.toString();
	}

	public void openAll() {
		grid.openAll();
	}

}
