package dummy;
import normal.NormalPosition;
import minesweeper.Grid;
import minesweeper.Position;
import minesweeper.Row;
import minesweeper.Square;

public class DummyGrid implements Grid{
	
	private Row rows[];
	public DummyGrid(int row, int col){
		int rowPlusDummy = row + 2;
		int colPlusDummy = col + 2;
				
		rows = new Row[rowPlusDummy];
		for ( int i = 0; i < rowPlusDummy; i++){
			rows[i] = new Row(col);
			if (i == 0 || i == rowPlusDummy-1){
				rows[i].setAllDummy();
			}
			else{
				rows[i].setDummy();
			}
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
		int dummyRow = row+1;
		int dummyCol = col+1;
		return rows[dummyRow].getSquare(dummyCol);
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
		return new DummyPosition(x, y);
	}

}