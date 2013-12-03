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
		
		if(getSquare(row, col).isMine()) return;
		for (int i = startRow; i <= endRow; i++) {
			Row rowOfGrid = rows[i];
			
			rowOfGrid.increaseNearNumberOfMine(col);
			if (i == row) {
				rowOfGrid.setMine(col);
			}
		}
	}

	public int openSquare(int row, int col) throws GameoverException {
		Square square = getSquare(row, col);
		square.setOpen();
		if (!square.isMine()) {
			int startRow = (row - 1 < 0) ? row : row - 1;
			int endRow = (row + 1 < getRow()) ? row + 1 : row;

			if (square.getNumOfNearMines() == 0){
				for (int i = startRow; i <= endRow; i++) {
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
			for (int j = 0; j < getCol(); j++) {
				result.append(getSquare(i, j).printSymbol());
			}
			result.append("\n");
		}
		System.out.println(result.toString());
		return result.toString();
	}

	public void openAll() {
		for (int i = 0; i < getRow(); i++) {
			rows[i].openAll();
		}

	}

}
