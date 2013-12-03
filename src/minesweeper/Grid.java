package minesweeper;

public class Grid {

	private int numberOfMine = 0;

	private Row rows[];

	public Grid(int row, int col) {
		rows = new Row[row];
		for (int i = 0; i < rows.length; i++) {
			rows[i] = new Row(col);
		}
	}

	public int getRow() {
		return rows.length;
	}

	public int getCol() {
		return rows[0].sizeOfColumn();
	}

	public int getNumberOfMine() {
		return numberOfMine;
	}

	private Square findSquare(int row, int column) {
		return rows[row].findSquare(column);
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
			for (int j = 0; j < getCol(); j++) {
				if (!findSquare(i, j).isOpen()) {
					return false;
				}
			}
		}
		return true;
	}

	public void putMine(int row, int col) {
		if (!isValidPosition(row, col)) {
			return;
		}

		if (!findSquare(row, col).hasMine()) {
			int startRow = (row - 1 < 0) ? row : row - 1;
			int endRow = (row + 1 < getRow()) ? row + 1 : row;

			for (int i = startRow; i <= endRow; i++) {
				Row rowOfGrid = rows[i];
				rowOfGrid.increaseMineCount(col);
				if (i == row) {
					rowOfGrid.putMine(col);
				}
			}
			++numberOfMine;
		}
	}

	public int openSquare(int i, int j) {
		if (!isValidPosition(i, j)) {
			return 0;
		}

		Square square = findSquare(i, j);
		square.setOpen();
		if (square.isNoNeighborMine()) {
			openSquare(i + 1, j);
			openSquare(i, j + 1);
		}

		if (square.hasMine()) {
			return 0;
		}
		return numberOfMine;
	}

	private boolean isValidPosition(int i, int j) {
		return (i > -1 && i < getRow()) && (j > -1 && j < getCol());
	}

	public boolean isFlag(int i, int j) {
		return findSquare(i, j).isFlag();
	}

	public void setFlag(int i, int j) {
		findSquare(i, j).setFlag();
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

	public String generate() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < getRow(); i++) {
			for (int j = 0; j < getCol(); j++) {
				sb.append(findSquare(i, j).status());
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
		return sb.toString();
	}
}
