package minesweeper;

import normal.NormalPosition;

public interface Grid {

	public abstract int getRow();

	public abstract int getCol();

	public abstract Square getSquare(int row, int col);

	public abstract boolean isAllOpen();

	public abstract void openAll();
	
	public Position createPosition(int x, int y);

}