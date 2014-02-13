package minesweeper;

import java.util.ArrayList;

public class ListPosition implements Position {

	private int x;
	private int y;

	public ListPosition(int x, int y) {
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
		int startRow = (x - 1 < 0) ? x : x - 1;
		int endRow = (x + 1 < row) ? x + 1 : x;
		
		int startCol = (y-1 < 0)? y : y-1;
		int endCol = (y+1 < col)? y+1 : y;
		
		ArrayList<Position> neighbors = new ArrayList<Position>();
		
		for (int i = startRow; i <= endRow; i++) {
			for (int j = startCol; j <= endCol; j++) {
				neighbors.add(new ListPosition(i, j));
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
		ListPosition other = (ListPosition) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

}
