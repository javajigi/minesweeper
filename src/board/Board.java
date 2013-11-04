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
				if(!board[i][j].isOpen()) { wincheck++; }
			}
		}
		if (wincheck == 0) {
			return true;
		}
		return false;
	}
}
