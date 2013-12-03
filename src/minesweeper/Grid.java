package minesweeper;

import java.util.ArrayList;
import java.util.List;

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

	private List<Square> findAllClosedSquare() {
		List<Square> closedSquares = new ArrayList<Square>();
		for (int i = 0; i < getRow(); i++) {
			for (int j = 0; j < getCol(); j++) {
				Square square = findSquare(i, j);
				if (!square.isOpen()){
					closedSquares.add(square);
				}
			}
		}
		return closedSquares;
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

	public int openSquare(int row, int col) throws LoseGameException {
		if (!isValidPosition(row, col)) {
			return 0;
		}

		Square square = findSquare(row, col);
		square.setOpen();
		if (square.isNoNeighborMine()) {
			openSquare(row + 1, col);
			openSquare(row, col + 1);
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
	
	public boolean isWin() {
		if (isAllOpen()) {
			return true;
		}
		
		for (Square each : findAllClosedSquare()) {
			if (!each.hasMine()) {
				return false;
			}
		}
		
		return true;
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
