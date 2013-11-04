package board;

public class Board {
	public int boardSizeX = 1;
	public int boardSizeY = 1;
	private int board[][] = new int[boardSizeX][boardSizeY];
	
	public Board() {
		for(int i=0; i<boardSizeX ; i++) {
			for(int j=0; j<boardSizeY; j++) {
				board[i][j] = 0;
			}
		}
	}
	
	public int getposition(Position pos){
		return board[pos.x][pos.y];
	}
}
