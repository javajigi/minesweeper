package minesweeper;

import java.util.ArrayList;

import dummy.DummyPosition;

abstract public class NormalListPosition {
	public int x;
	public int y;
	

	
	public ArrayList<Position> getNeighbors(int row, int col) {
		ArrayList<Position> neighbors = new ArrayList<Position>();
		int startRow = (x - 1 < 0) ? x : x - 1;
		int endRow = (x + 1 < row) ? x + 1 : x;
		
		int startCol = (y-1 < 0)? y : y-1;
		int endCol = (y+1 < col)? y+1 : y;
		
		neighbors = addNeighbors(startRow, endRow, startCol, endCol);
		
		neighbors.remove(this);
		return neighbors;
	}
	
	abstract ArrayList<Position> addNeighbors(int startRow, int endRow, int startCol, int endCol);
	
}
	
