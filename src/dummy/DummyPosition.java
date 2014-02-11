package dummy;

import java.util.ArrayList;

import normal.NormalPosition;
import minesweeper.Position;

public class DummyPosition implements Position {
	private int x;
	private int y;
	
	DummyPosition(int x, int y){
		this.x = x+1;
		this.y = y+1;
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
		int startRow = row-1;
		int startCol = row-1;
		int endRow = row+1;
		int endCol = row+1;
		
		ArrayList<Position> neighbors = new ArrayList<>();
		
		for (int i = startRow ; i <= endRow; i++){
			for (int j = startCol; i <= endCol ; i++){
				neighbors.add(new DummyPosition(i, j));
			}
		}
		neighbors.remove(this);
		return neighbors;
	}


}
