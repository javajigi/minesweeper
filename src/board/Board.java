package board;

public class Board {
	public int boardSizeX = 1;
	public int boardSizeY = 1;
	private Point board[][] = new Point[boardSizeX][boardSizeY];
	
	public Board() {
		for(int i=0; i<boardSizeX ; i++) {
			for(int j=0; j<boardSizeY; j++) {
				board[i][j] = new Point();
			}
		}
	}
	
	public Point getposition(Position pos){
		return board[pos.x][pos.y];
	}

	public boolean isWin() {
		int wincheck=0;
		for(int i=0; i<boardSizeX ; i++) {
			for(int j=0; j<boardSizeY; j++) {
				if(board[i][j].isOpen()) { wincheck++; }
				if(!board[i][j].isOpen() && board[i][j].isBoom()) { wincheck++; }
			}
		}
		if (wincheck == boardSizeX*boardSizeY) {
			return true;
		}
		return false;
	}
	
	public boolean isLose(Position pos) {
		if(board[pos.x][pos.y].isBoom()) {
			return true;
		}
		return false;
			
	}
}
