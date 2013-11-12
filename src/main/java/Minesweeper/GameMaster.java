package Minesweeper;

import java.util.Scanner;

public class GameMaster {
	Scanner scanner = new Scanner(System.in);
	public static enum GameStatus {
		WIN, GAMING, LOSE
	}

	public void gameStart() {
		int XNum, YNum, mines;

		System.out.println("Type the X-Num : ");
		XNum = scanner.nextInt();

		System.out.println("Type the Y-Num : ");
		YNum = scanner.nextInt();

		System.out.println("Type the Mines : ");
		mines = scanner.nextInt();

		BoardController board = Board.createBoard(XNum, YNum, mines);
		while (checkStatus(board).equals(GameStatus.GAMING)) {
			BoardConsolePrinter.printConsoleBoard(board);
			controlBlock(board);
		}

		if (checkStatus(board).equals(GameStatus.LOSE)) {
			board.openAllMines();
			BoardConsolePrinter.printConsoleBoard(board);
			System.out.println("You Lose");
		}
		else if (checkStatus(board).equals(GameStatus.WIN)) {
			BoardConsolePrinter.printConsoleBoard(board);
			System.out.println("You Win");
		}
		else
			;
	}

	public static GameStatus checkStatus(BoardController board) {
		board.calcBoard();

		int numofBlocks = board.getNumOfBlocks();
		int numofMines = board.getNumOfMines();
		int numofEntireMines = board.getNumOfMines() - board.getNumOfFlagedBlocks();
		int numofInvisibleBlocks = board.getNumOfInvisibleBlocks();

		if (board.isAnyMineBomb())
			return GameStatus.LOSE;

		else if (numofInvisibleBlocks == numofMines)
			return GameStatus.WIN;

		else
			return GameStatus.GAMING;
	}

	private void controlBlock(BoardController board) {
		String axis;
		int action;

		System.out.println("Type the Axis : ");
		axis = scanner.next();

		System.out.println("1 : Open Block, 2 : Toggle Flag, else : No Check");
		action = scanner.nextInt();

		if (action==1)
			board.openBlock(axis);
		else if (action==2) {
			if (board.getBlock(axis).isFlag())
				board.getBlock(axis).setFlag(false);
			else
				board.getBlock(axis).setFlag(true);
		}
		else
			;
	}
}
