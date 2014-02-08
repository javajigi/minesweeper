package minesweeper;

public class NormalGrid implements Grid {

	private Row rows[];

	public NormalGrid(int row, int col) {
		rows = new Row[row];
		for (int i = 0; i < row; i++) {
			rows[i] = new Row(col);
		}
	}

	/* (non-Javadoc)
	 * @see minesweeper.Grid#getRow()
	 */
	@Override
	public int getRow() {
		return rows.length;
	}

	/* (non-Javadoc)
	 * @see minesweeper.Grid#getCol()
	 */
	@Override
	public int getCol() {
		return rows[0].getCol();
	}

	/* (non-Javadoc)
	 * @see minesweeper.Grid#getSquare(int, int)
	 */
	@Override
	public Square getSquare(int row, int col) {
		return rows[row].getSquare(col);
	}
	
	/* (non-Javadoc)
	 * @see minesweeper.Grid#openAll()
	 */
	@Override
	public void openAll() {
		for (int i = 0; i < getRow(); i++) {
			rows[i].openAll();
		}
	}

	@Override
	public Position createPosition(int x, int y) {
		return new NormalPosition(x, y);
	}
}
