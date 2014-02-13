package minesweeper;

public class ListGrid implements Grid  {
	
	private Square square[];
	private int row;
	private int col;
	private int lenght;

	public ListGrid(int row, int col) {
		this.row = row;
		this.col = col;
		this.lenght = row*col;
		
	}
	@Override
	public int getRow() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getCol() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Square getSquare(int row, int col) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void openAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Position createPosition(int x, int y) {
		// TODO Auto-generated method stub
		return null;
	}

}
