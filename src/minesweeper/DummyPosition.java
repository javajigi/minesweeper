package minesweeper;

import java.util.ArrayList;

public class DummyPosition implements Position {
	
	private int x;
	private int y;
	
	private boolean isDummy(int x, int y, int row, int col) {
		if(x==0 || y ==0 || x == row+1  || y == col+1) {
			return true;
		}
		return false;
	}

	public DummyPosition(int x, int y) {
		this.x = x+1;
		this.y = y+1;
	}


	@Override
	public int getX() {
		return x-1;
	}

	@Override
	public int getY() {
		return y-1;
	}

	@Override
	public ArrayList<Position> getNeighbors(int row, int col) {
		int startRow = x - 1;
		int endRow = x + 1;
		
		int startCol =  y - 1;
		int endCol = y + 1;
		
		ArrayList<Position> neighbors = new ArrayList<Position>();
		
		for (int i = startRow; i <= endRow; i++) {
			for (int j = startCol; j <= endCol; j++) {
				if(!isDummy(i, j, row, col)) {
					neighbors.add(new DummyPosition(i-1,j-1));
				}
			}
		}
		neighbors.remove(this);
		
		return neighbors;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DummyPosition other = (DummyPosition) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
}
