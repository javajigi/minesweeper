package normal;

import minesweeper.Grid;
import minesweeper.Position;
import minesweeper.Row;
import minesweeper.Square;

public class NormalGrid implements Grid {

	private Row rows[];

	public NormalGrid(int row, int col) {
		rows = new Row[row];
		for (int i = 0; i < row; i++) {
			rows[i] = new Row(col);
		}
	}

	@Override
	public int getRow() {
		return rows.length;
	}

	@Override
	public int getCol() {
		return rows[0].getCol();
	}

	@Override
	public Square getSquare(int row, int col) {
		return rows[row].getSquare(col);
	}
	
	@Override
	public boolean isAllOpen() {
		for (int i = 0; i < getRow(); i++) {
			Row row = rows[i];
			if (!row.isAllOpen()) {
				return false;
			}
		}
		return true;
	}
	
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
