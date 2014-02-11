package list;

import minesweeper.Grid;
import minesweeper.Position;
import minesweeper.Square;

public class ListGrid implements Grid{

	private int rowLength;
	private int colLength;
	private Square[] squares;
	
	public ListGrid(int row, int col) {
		this.rowLength = row;
		this.colLength = col;
		int length = row * col;
		squares = new Square[length];
		for (int i = 0; i < length ; i ++){
			squares[i] = new Square();
		}
	}
	

	@Override
	public int getRow() {
		return this.rowLength;
	}

	@Override
	public int getCol() {
		return this.colLength;
	}

	@Override
	public Square getSquare(int row, int col) {
		int index = colLength * row + col;
		return squares[index];
	}

	@Override
	public boolean isAllOpen() {
		for ( int i = 0 ; i < squares.length ; i++){
			if (!squares[i].isOpen()) return false;
		}
		
		return true;
	}

	@Override
	public void openAll() {
		for ( int i = 0 ; i < squares.length ; i++){
			squares[i].setOpen();
		}
		
	}

	@Override
	public Position createPosition(int x, int y) {
		return new ListPosition(x, y);
	}

}
