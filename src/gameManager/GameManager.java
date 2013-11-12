package gameManager;

import grid.Grid;
import grid.Grid.square;

public class GameManager {

	private Grid grid;

	public void newGame(int x, int y, int z) {
		grid = new Grid();
		grid.init(x, y);
		grid.setMine(z);
	}

	public void openSquare(int i, int j) {
		if (grid.grid[i - 1][j - 1][1] == square.NONE) {
			System.out.println("노지뢰");
			if (isWin()) {
				System.out.println("헐 이김");
				endGame();
			}
			System.out.println(getMineAround(i, j));
			return;
		}
		System.out.println("패배ㅋ");
		endGame();
	}
	
	private int getMineAround(int row, int col){
		int mineAround = 0;
		for (int i = row-1; i < row+2; i++) {
			if (i <0 || i >=grid.getRowSize())
				continue;
			for (int j = col-1; j < col+2; j++) {
				if (j <0 || j >=grid.getColSize())
					continue;
				if (grid.grid[i][j][1] == square.MINE) {
					++mineAround;
				}
			}
		}
		return mineAround;
	}

	private boolean isWin() {
		return true;
	}

	private void endGame() {
		System.out.println("게임 끗");
	}
}
