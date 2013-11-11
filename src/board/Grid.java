package board;

public class Grid {
	public int girdSizeX=3;
	public int girdSizeY=3;
	private Square grid[][] = new Square[girdSizeX][girdSizeY];
	public boolean isLose = false;

	public Grid() {
//		girdSizeX = x;
//		gridSizeY = y;
		for (int i = 0; i < girdSizeX; i++) {
			for (int j = 0; j < girdSizeY; j++) {
				grid[i][j] = new Square();
			}
		}
	}

	public Square getSquare(Position pos) {
		return grid[pos.x][pos.y];
	}

	public int openSquare(Position pos) {
		grid[pos.x][pos.y].setOpen(true);
		if(grid[pos.x][pos.y].isMine()) {
			isLose = true;
			System.out.println("you lose!");
		}
		checkNumberOfMine(pos);
		
		return grid[pos.x][pos.y].getHint();
	}

	private void checkNumberOfMine(Position pos) {
		int startX, startY, endX, endY;
		int hint=0;
		startX = (pos.x-1 >= 0)? pos.x-1 : pos.x;
		startY = (pos.y-1 >= 0)? pos.y-1 : pos.y;
		endX = (pos.x+1 <= girdSizeX)? pos.x+1 : pos.x;
		endY = (pos.y+1 <= girdSizeY)? pos.y+1 : pos.y;
		
		for (int i = startX ; i <= endX; i++) {
			for (int j = startY; j <= endY; j++) {
				if(!(pos.x == i && pos.y == j)){
					if(grid[i][j].isMine()) { hint++; }
				}
			}
		}
		grid[pos.x][pos.y].setHint(hint);
	}

	public void setFlagOnSquare(Position pos) {
		grid[pos.x][pos.y].setFlag(true);
	}

	public boolean isWin() {
		int wincheck = 0;
		for (int i = 0; i < girdSizeX; i++) {
			for (int j = 0; j < girdSizeY; j++) {
				if (grid[i][j].isOpen()) {
					wincheck++;
				}
				if (!grid[i][j].isOpen() && grid[i][j].isMine()) {
					wincheck++;
				}
			}
		}
		if (wincheck == girdSizeX * girdSizeY) {
			return true;
		}
		return false;
	}

	public boolean isLose(Position pos) {
		if (grid[pos.x][pos.y].isMine()) {
			return true;
		}
		return false;

	}

}
