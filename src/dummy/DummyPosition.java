package dummy;

import java.util.ArrayList;
import minesweeper.Position;

public class DummyPosition implements Position {
	private int x;
	private int y;
	
	DummyPosition(int x, int y){
		this.x = x;
		this.y = y;
	}

	@Override
	public int getX() {
		return this.x;
	}

	@Override
	public int getY() {
		return this.y;
	}
	
	@Override
	public ArrayList<Position> getNeighbors(int row, int col) {
		//Dummy는 row, col에 상관없이 자신의 +1, -1 총 9가지의 list를 가짐 
		int startRow = this.x-1;
		int startCol = this.y-1;
		int endRow = this.x+1;
		int endCol = this.y+1;
		
		ArrayList<Position> neighbors = new ArrayList<>();

		for (int i = startRow ; i <= endRow; i++){
			for (int j = startCol; j <= endCol ; j++){
				neighbors.add(new DummyPosition(i, j));
			}
		}
		neighbors.remove(this);
		return neighbors;
	}


}
