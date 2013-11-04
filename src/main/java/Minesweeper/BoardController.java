package Minesweeper;

public interface BoardController {

	void setMine (int xAxis, int yAxis, boolean mine);
	void setFlag (int xAxis, int yAxis, boolean flag);
	void setShow (int xAxis, int yAxis, boolean show);

	int getNumofInvisibleBlocks();
	int getNumofFlagedBlocks();
	int getNumofMines();
	int getNumofBlocks();

	int getNumofNearMines(int xAxis, int yAxis);

	boolean isBomb();

	void calcBoard();
}
