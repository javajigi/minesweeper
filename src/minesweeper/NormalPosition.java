package minesweeper;

import java.util.ArrayList;

public class NormalPosition extends NormalListPosition implements Position {
	private int x;
	private int y;

	public NormalPosition(int x, int y) {
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
	ArrayList<Position> addNeighbors(int startRow, int endRow, int startCol,
			int endCol) {
		ArrayList<Position> neighbors = new ArrayList<Position>();
		for (int i = startRow; i <= endRow; i++) {
			for (int j = startCol; j <= endCol; j++) {
				neighbors.add(new NormalPosition(i, j));
			}
		}
		return neighbors;
	}


}
