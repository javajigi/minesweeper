package minesweeper;

public class DummyGrid implements Grid {

	private Row rows[];

	public DummyGrid(int row, int col) {
		int dummyRow = row+2;
		int dummyCol = col+2;
		
		rows = new Row[dummyRow];
		for (int i = 0; i < dummyRow; i++) {
			rows[i] = new Row(dummyCol);
		}
	}
	
	@Override
	public int getRow() {
		return rows.length-2;
	}

	@Override
	public int getCol() {
		return rows[0].getCol()-2;
	}

	@Override
	public Square getSquare(int row, int col) {
		return rows[row+1].getSquare(col+1);
	}

	@Override
	public boolean isAllOpen() {
		for (int i = 0; i < getRow(); i++) {
			Row row = rows[i+1];
			if (!row.isAllOpen()) {
				return false;
			}
		}
		return true;
	}

	@Override
	public void openAll() {
		for (int i = 0; i < getRow(); i++) {
			rows[i+1].openAll();
		}
	}

	@Override
	public Position createPosition(int x, int y) {
		return new DummyPosition(x, y);
	}

}
