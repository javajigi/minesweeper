package gameManager;

import board.Grid;

public class GameManager {

	private Grid inGameBoard;

	public void newGame(int x, int y, int z) {
		inGameBoard = new Grid();
		inGameBoard.init(x, y);
		inGameBoard.setMine(z);
	}

	public void openSquare(int i, int j) {
		if (inGameBoard.board[i - 1][j - 1] == false) {
			System.out.println("노지뢰");
			if (isWin()) {
				System.out.println("헐 이김");
				endGame();
			}
			return;
		}
		System.out.println("패배ㅋ");
		endGame();
	}

	private boolean isWin() {
		return true;
	}

	private void endGame() {
		System.out.println("게임 끗");
	}
}
