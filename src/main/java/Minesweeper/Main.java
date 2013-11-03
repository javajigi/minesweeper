package Minesweeper;

import static Minesweeper.GameMaster.*;

public class Main {
	public static void main(String[] args) {
		System.out.println("Game Start");

		// X축, Y축, Mine갯수 받고 Board create, Mine set

		Board gameBoard = new Board(1, 1, 1);

		while (GameMaster.checkStatus(gameBoard)==GameStatus.GAMING)
		{

		}

		// win

		// lose
	}
}
