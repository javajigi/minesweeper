package minesweeper;

public class Grid {

	private int numberOfMine = 0;

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

	public int getNumberOfMine() {
		return numberOfMine;
	}

	public boolean isGameOver() {
		if (numberOfMine == getRow() * getCol()) {
			return true;
		}

		if (isAllOpen()) {
			return true;
		}
		return false;
	}

	private boolean isAllOpen() {
		for (int i = 0; i < getRow(); i++) {
			Row row = rows[i];
			if (!row.isAllOpen()) {
				return false;
			}
		}
		return true;
	}

	public void putMine(int row, int col) {
		int startRow = (row - 1 < 0) ? row : row - 1;
		int endRow = (row + 1 < getRow()) ? row + 1 : row;

		for (int i = startRow; i <= endRow; i++) {
			Row rowOfGrid = rows[i];
			rowOfGrid.putMine(col);
			if (i == row) {
				rowOfGrid.setMine(col);
			}
		}
	}

	public int openSquare(int i, int j) {
		Square square = getSquare(i, j);
		square.setOpen();
		if (!square.isMine())
			return square.getNumOfNearMines();

		return 0;
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

	public boolean isLose() {
		for (int i = 0; i < getRow(); i++) {
			Row row = rows[i];
			if (row.isLose()) {
				return true;
			}
		}
		return false;
	}

	public String printConsole() {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < getRow(); i++) {
			for (int j = 0; j < getCol(); j++) {
				result.append(getSquare(i, j).printSymbol());
			}
			result.append("\n");
		}
		return result.toString();
	}

}
