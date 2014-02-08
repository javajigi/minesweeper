package minesweeper;

public interface Grid {

	public abstract int getRow();

	public abstract int getCol();

	public abstract Square getSquare(int row, int col);

	public abstract void openAll();
	
	public Position createPosition(int x, int y);

}