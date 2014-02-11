package dummy;
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
			rows[i] = new Row(colPlusDummy);
			if (i == 0 || i == rowPlusDummy -1 ){
				rows[i].setAllDummy();
			}
			else{
				rows[i].setDummy();
			}
		}
	}

	@Override
	public int getRow() { //normal과 달리 더미노드 때문에 양 옆을 -2
		return rows.length - 2;
	}

	@Override
	public int getCol() {  //normal과 달리 더미노드 때문에 위 아래를 -2
		return rows[0].getCol() - 2;
	}

	@Override
	public Square getSquare(int row, int col) { //더미노드 때문에 row와 col을 각각 +1
		int dummyRow = row+1;
		int dummyCol = col+1;
		return rows[dummyRow].getSquare(dummyCol);
	}

	@Override
	public boolean isAllOpen() {
		for (int i = 1; i <= getRow(); i++) {
			Row row = rows[i];
			if (!row.isAllOpen()) {
				return false;
			}
		}
		return true;
	}

	@Override
	public void openAll() {
		for (int i = 1; i <= getRow(); i++) {
			rows[i].openAll();
		}
		
	}

	@Override
	public Position createPosition(int x, int y) {
		return new DummyPosition(x, y);
	}

}