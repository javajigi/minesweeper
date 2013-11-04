package Minesweeper;

public class GameMaster {
	public static enum GameStatus {
		WIN, GAMING, LOSE
	}

	public GameMaster() {
	}

	public static GameStatus checkStatus(BoardController board) {
		board.calcBoard();

		int numofBlocks = board.getNumofBlocks();
		int numofMines = board.getNumofMines();
		int numofEntireMines = board.getNumofMines() - board.getNumofFlagedBlocks();
		int numofInvisibleBlocks = board.getNumofInvisibleBlocks();

		System.out.println("NumofBlocks : " + numofBlocks);
		System.out.println("NumofMines : " + numofMines);
		System.out.println("NumofEntireMines : " + numofEntireMines);
		System.out.println("NumofInvisibleBlocks : " + numofInvisibleBlocks);

		if (board.isBomb())
			return GameStatus.LOSE;

		else if (numofInvisibleBlocks == numofMines)
			return GameStatus.WIN;

		else
			return GameStatus.GAMING;
	}

	public static void nowGaming(BoardController board) {
		while (checkStatus(board).equals(GameStatus.GAMING)) {

		}

		if (checkStatus(board).equals(GameStatus.LOSE)) {
			board.openAllMines();
		}
		else
			;
	}



}
