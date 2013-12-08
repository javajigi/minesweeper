package minesweeper;

import java.util.Random;

public class Grid {

	private int totalNumberOfMine = 0;

	private Row rows[];

	public Grid(int row, int col) {
		rows = new Row[row];
		for (int i = 0; i < row; i++) {
			rows[i] = new Row(col);
		}
	}

	public int getRow() {
		return rows.length;
	}

	public int getCol() {
		return rows[0].getCol();
	}

	public int getTotalNumberOfMine() {
		return totalNumberOfMine;
	}

	public boolean isGameOver() {
		for (int i = 0; i < getRow(); i++) {
			if(!rows[i].isGameOver()) {
				return false;
			}
		}
		return true;
	}

	public void putMine(int row, int col) {
		if (getSquare(row, col).isMine())
			return;
		for (int i = checkGridBoundary(row - 1); i <= checkGridBoundary(row + 1); i++) {
			Row rowOfGrid = rows[i];
			rowOfGrid.increaseNearNumberOfMine(col);
			if (i == row) {
				rowOfGrid.setMine(col);
			}
		}
		totalNumberOfMine++;
	}

	public int openSquare(int row, int col) throws GameoverException {
		Square square = getSquare(row, col);
		square.setOpen();
		if (!square.isMine()) {
			if (square.hasNotNearMine()) {
				for (int i = checkGridBoundary(row - 1); i <= checkGridBoundary(row + 1); i++) {
					Row rowOfGrid = rows[i];
					rowOfGrid.openSquare(i, col, this);
				}
			}

			return square.getNumOfNearMines();
		}
		throw new GameoverException();
	}

	public Square getSquare(int row, int col) {
		return rows[row].getSquare(col);
	}

	public boolean isFlag(int i, int j) {
		return getSquare(i, j).isFlag();
	}

	public void setFlag(int i, int j) {
		getSquare(i, j).setFlag();
	}

	public String printConsole() {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < getRow(); i++) {
			result.append(rows[i].printConsole());
		}
		System.out.println(result.toString());
		return result.toString();
	}

	public void openAll() {
		for (int i = 0; i < getRow(); i++) {
			rows[i].openAll();
		}

	}

	public int checkGridBoundary(int row) {
		if (row < 0) {
			return 0;
		} else if (row >= getRow()) {
			return getRow() - 1;
		}
		return row;
	}

	public void setRandomMine(int numberOfMine) {
		Random intRandom = new Random();
		int row, col;

		for (int i = 0; i < numberOfMine; i++) {
			row = intRandom.nextInt(getRow());
			col = intRandom.nextInt(getCol());
			if(!getSquare(row, col).isMine()) {
				putMine(row, col);
			} else {
				i--;
			}
			
		}

	}

}
