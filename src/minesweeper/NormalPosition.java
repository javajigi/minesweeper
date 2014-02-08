package minesweeper;

import java.util.ArrayList;

public class NormalPosition implements Position {
	private int x;
	private int y;
	
	public NormalPosition(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	/* (non-Javadoc)
	 * @see minesweeper.Position#getX()
	 */
	@Override
	public int getX() {
		return x;
	}
	
	/* (non-Javadoc)
	 * @see minesweeper.Position#getY()
	 */
	@Override
	public int getY() {
		return y;
	}

	/* (non-Javadoc)
	 * @see minesweeper.Position#getNeighbors(int, int)
	 */
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

		return neighbors;
	}

	/* (non-Javadoc)
	 * @see minesweeper.Position#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	/* (non-Javadoc)
	 * @see minesweeper.Position#equals(java.lang.Object)
	 */
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
