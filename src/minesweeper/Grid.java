package minesweeper;

public class Grid {

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

	public Square getSquare(int row, int col) {
		return rows[row].getSquare(col);
	}
	
	public boolean isAllOpen() {
		for (int i = 0; i < getRow(); i++) {
			Row row = rows[i];
			if (!row.isAllOpen()) {
				return false;
			}
		}
		return true;
	}
	
	public void openAll() {
		for (int i = 0; i < getRow(); i++) {
			rows[i].openAll();
		}
	}
}
