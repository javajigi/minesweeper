package normal;

import java.util.ArrayList;

import minesweeper.Position;

public class NormalPosition implements Position{
	private int x;
	private int y;
	
	public NormalPosition(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public int getX() {
		return x;
	}
	@Override
	public int getY() {
		return y;
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
				neighbors.add(new NormalPosition(i, j));
			}
		}
		
		neighbors.remove(this);
		for (int i = 0 ; i < neighbors.size();i++){
			System.out.println(neighbors.get(i).getX());
			System.out.println(neighbors.get(i).getY());
		}
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
		NormalPosition other = (NormalPosition) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
}
