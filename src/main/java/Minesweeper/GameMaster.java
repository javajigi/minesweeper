package Minesweeper;

public class GameMaster {
	public static enum GameStatus {
		WIN, GAMING, LOSE;
	}

	private static GameStatus gameStatus;
	private static int NumofMines = 0;
	private static int NumofEntireMines = 0;
	private static int NumofInvisibleBlocks = 0;
	private static int NumofBlocks = 0;

	GameMaster() {
	}

	static void setGameStatus(GameStatus gameStatus) {
		GameMaster.gameStatus = gameStatus;
	}

	static GameStatus getGameStatus() {
		return gameStatus;
	}

	public static GameStatus checkStatus(BoardController board) {
		board.calcBoard();

		NumofBlocks = board.getNumofBlocks();
		NumofMines = board.getNumofMines();
		NumofEntireMines = board.getNumofMines() - board.getNumofFlagedBlocks();
		NumofInvisibleBlocks = board.getNumofInvisibleBlocks();

		System.out.println("NumofBlocks : " + NumofBlocks);
		System.out.println("NumofMines : " + NumofMines);
		System.out.println("NumofEntireMines : " + NumofEntireMines);
		System.out.println("NumofInvisibleBlocks : " + NumofInvisibleBlocks);

		if (board.isBomb()==true)
			return GameStatus.LOSE;

		else if (NumofInvisibleBlocks==NumofMines)
			return GameStatus.WIN;

		else
			return GameStatus.GAMING;
	}



}
