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
		
		square = new Square[lenght];
		
		for(int i=0 ; i<lenght ; i++) {
			square[i] = new Square();
		}
	}
	@Override
	public int getRow() {
		return this.row;
	}

	@Override
	public int getCol() {
		return this.col;
	}

	@Override
	public Square getSquare(int row, int col) {
		int index = row*this.col + col;
		return square[index];
	}

	@Override
	public void openAll() {
		for(int i=0 ; i<lenght ; i++){
			square[i].setOpen();
		}
	}

	@Override
	public Position createPosition(int x, int y) {
		return new ListPosition(x, y);
	}

}
