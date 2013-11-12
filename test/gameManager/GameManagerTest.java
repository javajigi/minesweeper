package gameManager;

import junit.framework.TestCase;

public class GameManagerTest extends TestCase {

	private GameManager GM = new GameManager();

	public void testWin() throws Exception {
		GM.newGame(2, 2, 1); // row의 길이, col의 길이, mine의 갯수 순서
		GM.openSquare(1, 1);
	}

	public void testLose() throws Exception {
		GM.newGame(1, 1, 1);
		GM.openSquare(1, 1);
	}

	public void testFlag() throws Exception {

	}
}
